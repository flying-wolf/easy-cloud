package com.superm.easy.cloud.commons.exception;

import com.superm.easy.cloud.commons.enums.ResponseMsg;
import com.superm.easy.cloud.commons.model.Resp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@SuppressWarnings("rawtypes")
@ControllerAdvice
@ResponseBody
public class CustomExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Resp sysErrorHandler(Exception exception, WebRequest request) {
        log.error("server error occured! request -- {}, {}", request.getContextPath(), exception);
        return Resp.error();
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Resp busiErrorHandler(BusinessException busiException, WebRequest request) {
        log.warn("business logic error occured! request -- {}, {}, code:{}", request.getContextPath(), busiException.getMessage(), busiException.getErrCode());
        return Resp.create(busiException.getErrCode(), busiException.getErrMsg());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Resp paramException(MissingServletRequestParameterException ex, WebRequest request) {
        log.error("param [ {} ] invalid in request {}!", ex.getParameterName(), request.getContextPath());
        return Resp.create(ResponseMsg.V4_PARAM_INVALID_CODE, ex.getParameterName());
    }

}
