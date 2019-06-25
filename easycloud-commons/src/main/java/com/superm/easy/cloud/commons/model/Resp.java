package com.superm.easy.cloud.commons.model;

import com.superm.easy.cloud.commons.enums.ResponseMsg;
import com.superm.easy.cloud.commons.exception.IMessage;
import com.superm.easy.cloud.commons.util.StringUtils;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Resp<T> implements Serializable {
    private static final long serialVersionUID = 6635069770718516064L;

    /**
     * 响应代码
     */
    protected String code;

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

    public Resp setResult(Object data) {
        this.data = (T)data;
        return this;
    }

    public static Resp success() {
        return create(ResponseMsg.SUCCESS);
    }

    /*public static Resp fail() {
        return create(ResponseMsg.FAIL);
    }*/

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
        return Resp.builder().code(code).message(msg).timestamp(String.valueOf(System.currentTimeMillis())).build();
    }

    public Resp toCreate(IMessage msg) {
        return  toCreate(msg.getCode(), msg.getMessage());
    }

    public Resp toCreate(String code, String msg) {
        return this.toBuilder().code(code).message(msg).timestamp(String.valueOf(System.currentTimeMillis())).build();
    }

}
