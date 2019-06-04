package com.superm.easy.cloud.apm.turbine;

import com.superm.easy.cloud.apm.turbine.constant.ConfigConstants;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-05-06 17:05
 **/
@EnableApolloConfig({
        ConfigConstants.NAMESPACE_APPLICATION,
        ConfigConstants.NAMESPACE_REGISTRY,
        ConfigConstants.NAMESPACE_STREAM
})
@EnableBinding
@EnableDiscoveryClient
@EnableTurbineStream
@SpringBootApplication
public class EasyCloudAPMTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyCloudAPMTurbineApplication.class, args);
    }
}
