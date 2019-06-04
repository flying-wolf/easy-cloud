package com.superm.easy.cloud.commons.exception;

/*
 * @author hu.sheng 2019/04/25
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -1760367626582900295L;
    protected String errCode = "";
    protected String errMsg = "";

    public BaseException() {
        super();
    }

    public BaseException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(msg, cause, enableSuppression, writableStackTrace);
    }

    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

}
