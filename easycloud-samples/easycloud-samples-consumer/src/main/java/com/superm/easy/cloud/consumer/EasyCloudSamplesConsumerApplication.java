package com.superm.easy.cloud.consumer;

import com.superm.easy.cloud.consumer.constant.ConfigConstants;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-24 19:24
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
public class EasyCloudSamplesConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyCloudSamplesConsumerApplication.class, args);
    }
}
