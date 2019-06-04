package com.superm.easy.cloud.gateway;

import com.superm.easy.cloud.gateway.constant.ConfigConstants;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: easy-cloud
 * @description: API网关服务启动器
 * @author: Chao.Ma
 * @create: 2019-04-23 17:45
 **/
@EnableApolloConfig({
        ConfigConstants.NAMESPACE_APPLICATION,
        ConfigConstants.NAMESPACE_REGISTRY,
        ConfigConstants.NAMESPACE_ROUTES,
        ConfigConstants.NAMESPACE_REDIS,
        ConfigConstants.NAMESPACE_STREAM
})
@EnableBinding
@EnableDiscoveryClient
@SpringBootApplication
public class EasyCloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyCloudGatewayApplication.class, args);
    }
}
