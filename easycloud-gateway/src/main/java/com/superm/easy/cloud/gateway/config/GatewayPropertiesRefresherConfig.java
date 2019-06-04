package com.superm.easy.cloud.gateway.config;

import com.superm.easy.cloud.gateway.constant.ConfigConstants;
import com.superm.easy.cloud.gateway.service.IDynamicRouteService;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @program: easy-cloud
 * @description: 服务网关属性刷新配置
 * @author: Chao.Ma
 * @create: 2019-04-23 17:59
 **/
@Slf4j
@Component
public class GatewayPropertiesRefresherConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Autowired
    private GatewayProperties gatewayProperties;
    @Autowired
    private IDynamicRouteService dynamicRouteService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * @description: apollo配置监听器，默认监听的是application命名空间
     * @param: [changeEvent]
     * @return: void
     * @author: Chao.Ma
     * @date: 2019/4/23
     **/
    @ApolloConfigChangeListener({
            ConfigConstants.NAMESPACE_APPLICATION,
            ConfigConstants.NAMESPACE_ROUTES
    })
    public void onChange(ConfigChangeEvent changeEvent) {
        boolean isChanged = false;
        for (String changedKey : changeEvent.changedKeys()) {
            //前缀为spring.cloud.gateway的key发生了改变(gateway的配置发生了改变)
            if (changedKey.startsWith(ConfigConstants.ROUTES_CHANGE_LISTENER_PREFIX)) {
                isChanged = true;
                break;
            }
        }
        //更新gateway配置
        if (isChanged) {
            refreshGatewayProperties(changeEvent);
        }
    }

    /**
     * @description: 更新SpringApplicationContext对象，并更新路由
     * @param: [changeEvent]
     * @return: void
     * @author: Chao.Ma
     * @date: 2019/4/23
     **/
    private void refreshGatewayProperties(ConfigChangeEvent changeEvent) {
        log.warn("Refreshing gateway properties!");

        // 更新配置
        applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));

        // 更新路由
        gatewayProperties.getRoutes().forEach(dynamicRouteService::update);

        log.warn("Gateway properties refreshed!");
    }
}
