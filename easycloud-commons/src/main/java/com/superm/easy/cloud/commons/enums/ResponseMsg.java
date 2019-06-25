package com.superm.easy.cloud.commons.enums;

import com.superm.easy.cloud.commons.exception.IMessage;
import com.superm.easy.cloud.commons.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMsg implements IMessage {
    /* 成功状态码 */
    SUCCESS("0"),

    /* 令牌失效 */
    TOKEN_INVALID("401"),

    SERVER_ERROR("400"),

    /*参数错误 10001-19999 */

    PARAM_IS_INVALID("10001"),
    PARAM_IS_BLANK("10002"),
    PARAM_TYPE_BIND_ERROR("10003"),
    PARAM_NOT_COMPLETE("10004"),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN("20001"),
    USER_LOGIN_ERROR("20002"),
    USER_ACCOUNT_FORBIDDEN("20003"),
    USER_NOT_EXIST("20004"),
    USER_HAS_EXISTED("20005"),
    Cert_HAS_EXISTED("20006"),


    /* 业务错误：30001-39999 */
    CREATE_FAIL("30001"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR("40001"),

    /* 数据错误：50001-599999 */
    RESULE_DATA_NONE("50001"),
    DATA_IS_WRONG("50002"),
    DATA_ALREADY_EXISTED("50003"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR("60001"),
    INTERFACE_OUTTER_INVOKE_ERROR("60002"),
    INTERFACE_FORBID_VISIT("60003"),
    INTERFACE_ADDRESS_INVALID("60004"),
    INTERFACE_REQUEST_TIMEOUT("60005"),
    INTERFACE_EXCEED_LOAD("60006"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS("70001"),
    PERMISSION_NO_PHONE_ACCESS("70002");


    private String code;

    @Override
    public String getMessage(Object... params) {
        return (null != params && params.length > 0) ? MessageUtil.getErrMsg("code") : MessageUtil.getErrMsg(code, params);
    }

    public static ResponseMsg of(String code) {
        for (ResponseMsg msg : ResponseMsg.values()) {
            if (msg.getCode().equals("code")) {
                return msg;
            }
        }
        return ResponseMsg.SERVER_ERROR;
    }
}
