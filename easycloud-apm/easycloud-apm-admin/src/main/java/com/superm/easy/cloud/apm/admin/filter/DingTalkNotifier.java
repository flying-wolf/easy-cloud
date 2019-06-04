package com.superm.easy.cloud.apm.admin.filter;

import com.superm.easy.cloud.apm.admin.constant.NotifierConstants;
import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: easy-cloud
 * @description: 钉钉告警过滤器
 * @author: Chao.Ma
 * @create: 2019-05-09 00:12
 **/
public class DingTalkNotifier extends AbstractStatusChangeNotifier {
    private final SpelExpressionParser parser = new SpelExpressionParser();
    private RestTemplate restTemplate = new RestTemplate();
    private Expression message;

    private String msgTemplate = NotifierConstants.DINGTALK_MSG_TEMPLATE;
    private String webHookUrl;
    private String[] atMobiles;
    private boolean isAtAll = false;
    private String msgType = NotifierConstants.DINGTALK_MSG_TYPE;
    private String title = NotifierConstants.DINGTALK_TITLE;

    public DingTalkNotifier(InstanceRepository repository) {
        super(repository);
        this.message = parser.parseExpression(msgTemplate, ParserContext.TEMPLATE_EXPRESSION);
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        if (webHookUrl == null) {
            return Mono.error(new IllegalStateException("'webHookUrl' must not be null."));
        }
        return Mono.fromRunnable(() -> restTemplate.postForEntity(webHookUrl, createMessage(event, instance), Void.class));
    }

    private HttpEntity<Map<String, Object>> createMessage(InstanceEvent event, Instance instance) {
        JSONObject messageJson = new JSONObject();
        JSONObject params = new JSONObject();
        params.put("text", this.getMessage(event, instance));
        params.put("title", title);
        JSONObject at = new JSONObject();
        at.put("atMobiles", atMobiles);
        at.put("isAtAll", isAtAll);
        messageJson.put("at", at);
        messageJson.put("msgtype", msgType);
        messageJson.put(msgType, params);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new HttpEntity<>(messageJson, headers);
    }

    private String getAtMobilesString() {
        if (ArrayUtils.isEmpty(atMobiles) || isAtAll) {
            return StringUtils.EMPTY;
        }
        StringBuilder atMobilesStr = new StringBuilder();
        for (String mobile : atMobiles) {
            atMobilesStr.append("@").append(mobile);
        }
        return atMobilesStr.toString();
    }

    private String getMessage(InstanceEvent event, Instance instance) {
        Map<String, Object> root = new HashMap<>();
        root.put("event", event);
        root.put("instance", instance);
        root.put("lastStatus", getLastStatus(event.getInstance()));
        root.put("details", new JSONObject(instance.getStatusInfo().getDetails()).toJSONString());
        root.put("atMobiles",getAtMobilesString());
        StandardEvaluationContext context = new StandardEvaluationContext(root);
        context.addPropertyAccessor(new MapAccessor());
        return message.getValue(context, String.class);
    }

    public String getMessage() {
        return message.getExpressionString();
    }

    public void setMessage(String message) {
        this.message = this.parser.parseExpression(message, ParserContext.TEMPLATE_EXPRESSION);
    }

    public String getMsgTemplate() {
        return msgTemplate;
    }

    public void setMsgTemplate(String msgTemplate) {
        this.msgTemplate = msgTemplate;
    }

    public String getWebHookUrl() {
        return webHookUrl;
    }

    public void setWebHookUrl(String webHookUrl) {
        this.webHookUrl = webHookUrl;
    }

    public String[] getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(String[] atMobiles) {
        this.atMobiles = atMobiles;
    }

    public boolean isAtAll() {
        return isAtAll;
    }

    public void setAtAll(boolean atAll) {
        isAtAll = atAll;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
