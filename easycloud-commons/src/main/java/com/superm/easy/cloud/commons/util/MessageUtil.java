package com.superm.easy.cloud.commons.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class MessageUtil {

    @Resource
    private MessageSource messageSource;
    private static MessageUtil messageUtil;

    @PostConstruct
    public void init() {
        messageUtil = this;
        messageUtil.messageSource = this.messageSource;
    }

    public static String getErrMsg(String code) {
        System.out.println(LocaleContextHolder.getLocale());
        return messageUtil.messageSource.getMessage(code, null, StringUtils.EMPTY, LocaleContextHolder.getLocale());
    }

    public static String getErrMsg(String code, Object... params) {
        System.out.println(LocaleContextHolder.getLocale());
        return messageUtil.messageSource.getMessage(code, params, StringUtils.EMPTY, LocaleContextHolder.getLocale());
    }
}
