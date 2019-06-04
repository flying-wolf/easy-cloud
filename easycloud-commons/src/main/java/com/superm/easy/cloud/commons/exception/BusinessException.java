package com.superm.easy.cloud.commons.exception;

public class BusinessException extends BaseException {

    private static final long serialVersionUID = 793812132995534317L;

    public static BusinessException createBusinessException(IMessage msg) {
        throw new BusinessException(msg.getCode(), msg.getMessage());
    }

    public static BusinessException createBusinessException(String code) {
        throw new BusinessException(code, null);
    }

    public static BusinessException createBusinessException(String code, String message) {
        throw new BusinessException(code, message);
    }

    public static BusinessException createBusinessException(String code, String message, Throwable cause) {
        throw new BusinessException(code, message, cause);
    }


    public BusinessException(String code, String message) {
        super();
        this.errCode = code;
        this.errMsg = message;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.errCode = code;
        this.errMsg = message;
    }

}
