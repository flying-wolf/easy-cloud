package com.superm.easy.cloud.apm.admin.constant;

public interface NotifierConstants {
    String DINGTALK_MSG_TEMPLATE = "**服务：** *#{instance.registration.name}*\n\n" +
            "**实例：** *#{instance.id}*\n\n" +
            "**事件：** *状态由* <font color=#FF0000 size=6>**#{lastStatus}**</font> *变更为* <font color=#FF0000 size=6>**#{event.statusInfo.status}**</font> \n\n" +
            "**细节：** ```#{details}``` \n\n" +
            "**服务Url：** #{instance.registration.serviceUrl} \n\n" +
            "**心跳Url：** #{instance.registration.healthUrl} \n\n" +
            "**监控Url：** #{instance.registration.managementUrl} \n\n" +
            "***请尽快处理！！！*** \n\n" +
            "#{atMobiles}";
    String DINGTALK_MSG_TYPE = "markdown";
    String DINGTALK_TITLE = "告警消息";

    String DINGTALK_PREFIX = "spring.boot.admin.notify.dingtalk";
    String DINGTALK_WEB_HOOK_LABEL = "webhook-url";
}
