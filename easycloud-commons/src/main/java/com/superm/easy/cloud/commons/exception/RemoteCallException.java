 package com.superm.easy.cloud.commons.exception;

 public class RemoteCallException extends BaseException {

    private static final long serialVersionUID = -8262165247891711460L;

    public RemoteCallException() {
        super();
    }

    public RemoteCallException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RemoteCallException(String msg) {
        super(msg);
    }

    public RemoteCallException(Throwable cause) {
        super(cause);
    }
    
}
