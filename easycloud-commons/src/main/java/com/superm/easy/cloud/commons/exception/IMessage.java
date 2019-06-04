package com.superm.easy.cloud.commons.exception;

public interface IMessage {
    /**
     * error code
     * @return String
     */
    String getCode();

    /**
     * error message
     * @return String
     */
    String getMessage(Object... params);

}
