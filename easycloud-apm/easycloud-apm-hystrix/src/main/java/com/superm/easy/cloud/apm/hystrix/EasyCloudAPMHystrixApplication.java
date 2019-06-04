package com.superm.easy.cloud.apm.hystrix;

import com.superm.easy.cloud.apm.hystrix.constant.ConfigConstants;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-05-05 16:08
 **/
@EnableApolloConfig({
        ConfigConstants.NAMESPACE_APPLICATION,
        ConfigConstants.NAMESPACE_REGISTRY
})
@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication
public class EasyCloudAPMHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyCloudAPMHystrixApplication.class, args);
    }
}
