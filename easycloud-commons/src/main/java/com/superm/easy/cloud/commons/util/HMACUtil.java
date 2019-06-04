package com.superm.easy.cloud.commons.util;

import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class HMACUtil {
	
	private static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
	
	private static final int PBKDF2_ITERATIONS = 1000;
	
	private static final int HASH_BYTE_SIZE = 24;
	
	/**
	 * sha1加密
	 * 
	 * @param key
	 * @param datas
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static String app_hmac_sha1(String key, String datas) {
		String reString = "";
		
		try {
			byte[] data = key.getBytes("UTF-8");
			SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(secretKey);
	
			byte[] text = datas.getBytes("UTF-8");
			byte[] text1 = mac.doFinal(text);
			reString = new String(new BASE64Encoder().encode(text1));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return reString;
	}
	
	/**
	 * sha1加密
	 * 
	 * @param key
	 * @param datas
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static String ipc_hmac_sha1(String key, String datas) {
		return new BASE64Encoder().encode(HMACSHA1.getHmacSHA1(datas, key));
	}
	
	/**
	 * Hmac加密
	 * @param map
	 * @param tokenStr
	 * @return
	 */
	public static String getHmac(Map<String, String> map, String tokenStr) {
		String params = "";
		for (String key : map.keySet()) {
			params += "&" + key + "=" + map.get(key);
		}
		if (params.length() > 0) {
			// filter the first '&'
			params = params.substring(1);
		}
		return app_hmac_sha1(tokenStr, params);
	}
	

	/**
     *  Computes the PBKDF2 hash of a password.
     *
     * @param   password    the password to hash.
     * @param   salt        the salt
     * @return              the PBDKF2 hash of the password
     */
    public static String pbkdf2(String password, String salt)
    {
    	String reString = "";
    	try {
    		char[] data = password.toCharArray();
    		byte[] saltByte = salt.getBytes("UTF-8");
	        PBEKeySpec spec = new PBEKeySpec(data, saltByte, PBKDF2_ITERATIONS, HASH_BYTE_SIZE * 8);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
	        byte[] hashpwd = skf.generateSecret(spec).getEncoded();
	        reString = new String(new BASE64Encoder().encode(hashpwd));
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	return reString;
    }
    	
    public static String formatHmacValue(List<String> names, List<String> values) {
    	StringBuilder buf = new StringBuilder();
    	for (int i = 0; i < names.size(); i++) {
    		if (values.get(i) != null) {
    			buf.append("&").append(names.get(i)).append("=").append(values.get(i));
    		}
    	}
    	return buf.deleteCharAt(0).toString();
    }
    
    public static String formatHmacValue(String... params) {
    	StringBuilder buf = new StringBuilder();
    	for (int i = 0; i < params.length; i=i+2) {
    		if (params[i+1] != null) {
    			buf.append("&").append(params[i]).append("=").append(params[i+1]);
    		}
    	}
    	return buf.deleteCharAt(0).toString();
    }
}
