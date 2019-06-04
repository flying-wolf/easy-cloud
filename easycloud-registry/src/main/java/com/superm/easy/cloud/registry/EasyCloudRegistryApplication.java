package com.superm.easy.cloud.registry;

import com.superm.easy.cloud.registry.constant.ConfigConstants;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: easy-cloud
 * @description: 注册中心启动类
 * @author: Chao.Ma
 * @create: 2019-04-23 14:31
 **/
@EnableApolloConfig({
        ConfigConstants.NAMESPACE_APPLICATION,
        ConfigConstants.NAMESPACE_REGISTRY
})
@EnableEurekaServer
@SpringBootApplication
public class EasyCloudRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyCloudRegistryApplication.class, args);
    }

}
