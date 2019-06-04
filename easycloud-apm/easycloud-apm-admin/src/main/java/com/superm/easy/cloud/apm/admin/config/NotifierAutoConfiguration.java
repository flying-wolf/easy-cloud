package com.superm.easy.cloud.apm.admin.config;

import com.superm.easy.cloud.apm.admin.constant.NotifierConstants;
import com.superm.easy.cloud.apm.admin.filter.DingTalkNotifier;
import de.codecentric.boot.admin.server.config.AdminServerNotifierAutoConfiguration;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: easy-cloud
 * @description: 钉钉告警通知
 * @author: Chao.Ma
 * @create: 2019-05-08 23:47
 **/
@Configuration
public class NotifierAutoConfiguration {

    @Configuration
    @ConditionalOnProperty(
            prefix = NotifierConstants.DINGTALK_PREFIX,
            name = NotifierConstants.DINGTALK_WEB_HOOK_LABEL
    )
    @AutoConfigureBefore({
            AdminServerNotifierAutoConfiguration.NotifierTriggerConfiguration.class,
            AdminServerNotifierAutoConfiguration.CompositeNotifierConfiguration.class
    })
    public static class DingTalkNotifierConfiguration {

        @Bean
        @ConditionalOnMissingBean
        @ConfigurationProperties(prefix = NotifierConstants.DINGTALK_PREFIX)
        public DingTalkNotifier dingTalkNotifier(InstanceRepository repository) {
            return new DingTalkNotifier(repository);
        }
    }
}
