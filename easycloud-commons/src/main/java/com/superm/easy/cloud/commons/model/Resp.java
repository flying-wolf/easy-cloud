package com.superm.easy.cloud.commons.model;

import com.superm.easy.cloud.commons.enums.ResponseMsg;
import com.superm.easy.cloud.commons.exception.IMessage;
import com.superm.easy.cloud.commons.util.StringUtils;
import lombok.ToString;

import java.io.Serializable;

@ToString
public class Resp<T> implements Serializable {
    private static final long serialVersionUID = 6635069770718516064L;

    /**
     * 响应代码
     */
    public String code;

    /**
     * 响应信息
     */
    protected String message;

    /**
     * 响应数据
     */
    protected T data;

    /**
     * 响应时间
     */
    protected String timestamp;

    public Resp() {
    }

    public Resp(String code, String message, String timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Resp(String code, String message, T data, String timestamp) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Resp setResult(Object data) {
        this.data = (T) data;
        return this;
    }

    public static Resp success() {
        return create(ResponseMsg.SUCCESS);
    }

    public static Resp failure() {
        return create(ResponseMsg.CREATE_FAIL);
    }

    public static Resp error() {
        return create(ResponseMsg.SERVER_ERROR);
    }

    public static Resp create(IMessage msg) {
        return create(msg.getCode(), msg.getMessage());
    }

    public static Resp create(IMessage msg, Object... params) {
        return create(msg.getCode(), msg.getMessage(params));
    }

    public static Resp create(String code) {
        return create(code, StringUtils.EMPTY);
    }

    public static Resp create(String code, String msg) {
        return new Resp(code, msg, String.valueOf(System.currentTimeMillis()));
    }

    public Resp toBuilder(IMessage msg) {
        return this.toBuilder(msg.getCode(), msg.getMessage());
    }

    public Resp toBuilder(String code, String msg) {
        this.setCode(code);
        this.setMessage(msg);
        this.setTimestamp(String.valueOf(System.currentTimeMillis()));
        return this;
    }

}
