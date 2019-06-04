package com.superm.easy.cloud.commons.exception;

/** 
 * @author hu.sheng
 * @since 20190425
 */
public class UnSerializableException extends BaseException {

    private static final long serialVersionUID = -2582832262582749235L;

    public UnSerializableException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UnSerializableException(String msg) {
        super(msg);
    }

    public UnSerializableException(Throwable cause) {
        super(cause);
    }

}
