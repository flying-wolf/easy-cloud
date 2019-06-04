package com.superm.easy.cloud.provider;

import com.superm.easy.cloud.provider.constant.ConfigConstants;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: easy-cloud
 * @description: 服务提供者启动器
 * @author: Chao.Ma
 * @create: 2019-04-24 01:20
 **/
@EnableApolloConfig({
        ConfigConstants.NAMESPACE_APPLICATION,
        ConfigConstants.NAMESPACE_REGISTRY,
        ConfigConstants.NAMESPACE_STREAM
})
@EnableBinding
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EasyCloudSamplesProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyCloudSamplesProviderApplication.class, args);
    }
}
