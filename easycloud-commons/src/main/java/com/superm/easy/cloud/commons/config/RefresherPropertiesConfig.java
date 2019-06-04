package com.superm.easy.cloud.commons.config;

import com.superm.easy.cloud.commons.constant.ConfigConstants;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-25 10:15
 **/
@Slf4j
@Configuration
@ConditionalOnClass({
        ApplicationContext.class,
        ApolloConfigChangeListener.class,
        EnableApolloConfig.class
})
@ConditionalOnProperty(prefix = ConfigConstants.APOLLO_BOOTSTRAP_PREFIX, value = ConfigConstants.ENABLED)
public class RefresherPropertiesConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @ApolloConfig
    private Config config;

    @PostConstruct
    private void initialize() {
        refresher(config.getPropertyNames());
    }

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent) {
        refresher(changeEvent.changedKeys());
    }

    private void refresher(Set<String> changedKeys) {
        for (String changedKey : changedKeys) {
            log.warn("this key is changed {} ", changedKey);
        }
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changedKeys));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
