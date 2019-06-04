// This should replace other http client utilities like HttpClientUtil, HttpRequestProxy and HttpXmlClient when
// the testing is ready

package com.superm.easy.cloud.commons.util;

import com.superm.easy.cloud.commons.exception.RemoteCallException;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;


/** 
 * @author hu.sheng
 * @since 20190425
 */
@SuppressWarnings("deprecation")
public class HttpClientHelper {
	private static final Logger logger = LoggerFactory.getLogger(HttpClientHelper.class);

	private static boolean alwaysClose = false;
	private static String defaultEncoding = "UTF-8";
	private PoolingHttpClientConnectionManager poolConnManager = null;
	private CloseableHttpClient httpClient;
	private RequestConfig requestConfig;

	private HttpClientHelper() {
		init();
	}

	private static class Handler {
		private static final HttpClientHelper INSTANCE = new HttpClientHelper();
	}

	public static final HttpClientHelper getInstance() {
		return Handler.INSTANCE;
	}

    private void init() {
		try {
			SSLContextBuilder builder = SSLContexts.custom();
			builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType)
								throws CertificateException {
					return true;
				}
			});
			SSLContext sslContext = builder.build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			// 配置同时支持 HTTP 和 HTPPS
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
							.<ConnectionSocketFactory>create()
							.register("http", PlainConnectionSocketFactory.INSTANCE)
							.register("https", sslsf).build();
			// 初始化连接管理器
			poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			// 将最大连接数增加到200，实际项目最好从配置文件中读取这个值
			poolConnManager.setMaxTotal(200);
			// 设置最大路由
			poolConnManager.setDefaultMaxPerRoute(20);
			// 根据默认超时限制初始化requestConfig
			int socketTimeout = 3000;
			int connectTimeout = 3000;
			int connectionRequestTimeout = 3000;
			requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH)
							.setExpectContinueEnabled(true)
							.setStaleConnectionCheckEnabled(true)
							.setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM,
											AuthSchemes.DIGEST))
							.setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))
							.setConnectionRequestTimeout(connectionRequestTimeout)
							.setSocketTimeout(socketTimeout)
							.setConnectTimeout(connectTimeout).build();
			// 初始化httpClient
			httpClient = getConnection();
		} catch (Exception e) {
			logger.error("init httpclient pool error!", e);
			throw new RemoteCallException(e);
		}
	}

	private CloseableHttpClient getConnection() {
		CloseableHttpClient httpClient = HttpClients.custom()
						// 设置连接池管理
						.setConnectionManager(poolConnManager)
						// 设置请求配置
						.setDefaultRequestConfig(requestConfig)
						// 设置重试次数
						.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)).build();
		if (poolConnManager != null && poolConnManager.getTotalStats() != null) {
			logger.warn("now client pool " + poolConnManager.getTotalStats().toString());
		}
		return httpClient;
	}

	public String get(String url) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		return doRequest(httpGet);
	}

	public String post(String url, Map<String, String> params) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : params.entrySet()) {
			postParameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
		return doRequest(httpPost);
	}

	public String postJson(String url, String jsonStr) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setEntity(new StringEntity(jsonStr));
		return doRequest(httpPost);
	}

	private String doRequest(HttpUriRequest request) throws Exception {
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, "utf-8");
			EntityUtils.consume(entity);
			return result;
		} finally {
			if (response != null) {
				response.close();
			}
		}
	}

	/**
	 * 用法 HttpClientUtil.doRequest("http://www.163.com",null,null,"gbk");
	 *
	 * @param method           POST or GET
	 * @param url              请求的资源ＵＲＬ
	 * @param params           POST请求时form表单封装的数据, GET请求时代表querystring中的参数
	 * @param headers          request请求时附带的头信息(headers) 没有时传null
	 * @param responseEncoding response返回的信息编码格式 没有时传null
	 * @return response返回的文本数据
	 */
	public static String doRequest(String method, String url, Map<String, String> params,
					Map<String, String> headers, String responseEncoding)
					throws RemoteCallException, UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			sb.append("&").append(entry.getKey()).append("=")
							.append(URLEncoder.encode(entry.getValue(), defaultEncoding));
		}
		String data = "";
		if (sb.length() > 0) {
			data = sb.toString().substring(1);
		}
		logger.debug("data to send: {}", data);
		return doRequest(method, url, data, headers,
						"application/x-www-form-urlencoded;charset=" + defaultEncoding,
						responseEncoding);
	}

	public static String doRequest(String method, String url, String data, Map<String, String> headers,
					String contentType, String responseEncoding)
					throws RemoteCallException, UnsupportedEncodingException {
		// 头部请求信息
		HttpMethod httpMethod;
		boolean isPost = method.equalsIgnoreCase("post");
		if (isPost) {
			httpMethod = new PostMethod(url.trim());
			((PostMethod) httpMethod).setRequestEntity(new StringRequestEntity(data, contentType, null));
		} else {
			String targetUrl = StringUtils.isNotBlank(data) ? url.concat("?").concat(data) : url;
			httpMethod = new GetMethod(targetUrl.trim());
		}

		if (headers != null) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				httpMethod.setRequestHeader(entry.getKey(), entry.getValue());
			}
		}

		String responseString = "";
		try {
			responseString = executeMethod(httpMethod, responseEncoding);
		} finally {
			httpMethod.releaseConnection();
		}

		return responseString;
	}

	private static String executeMethod(HttpMethod request, String encoding) throws RemoteCallException {
		String responseContent = null;
		InputStream responseStream = null;
		BufferedReader rd = null;
		Exception ex = null;

		try {
			HttpClient httpClient = new HttpClient(new SimpleHttpConnectionManager(alwaysClose));
			httpClient.executeMethod(request);

			if (encoding != null) {
				responseStream = request.getResponseBodyAsStream();
				rd = new BufferedReader(new InputStreamReader(responseStream, encoding));
				String tempLine = rd.readLine();
				StringBuilder tempStr = new StringBuilder();
				String crlf = System.getProperty("line.separator");
				while (tempLine != null) {
					tempStr.append(tempLine);
					tempStr.append(crlf);
					tempLine = rd.readLine();
				}
				responseContent = tempStr.toString();
			} else {
				responseContent = request.getResponseBodyAsString();
			}

			Header locationHeader = request.getResponseHeader("location");

			// 返回代码为302,301时，表示页面己经重定向，则重新请求location的url，这在
			// 一些登录授权取cookie时很重要
			if (locationHeader != null) {
				String redirectUrl = locationHeader.getValue();
				doRequest("get", redirectUrl, null, null, null, null);
			}
		} catch (Exception e) {
			logger.error("{}: {}", e.getMessage(), e);
			ex = e;
		}

		if (rd != null) {
			try {
				rd.close();
				responseStream.close();
			} catch (IOException e) {
				logger.error("{}: {}", e.getMessage(), e);
				throw new RemoteCallException(e.getMessage());
			}
		}

		if (ex != null) {
			throw new RemoteCallException(ex.getMessage());
		}
		return responseContent;
	}
	
}
