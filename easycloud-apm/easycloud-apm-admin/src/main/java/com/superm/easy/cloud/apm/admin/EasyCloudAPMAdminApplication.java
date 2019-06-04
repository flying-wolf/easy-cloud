package com.superm.easy.cloud.apm.admin;

import com.superm.easy.cloud.apm.admin.constant.ConfigConstants;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: easy-cloud
 * @description: 系统监控启动器
 * @author: Chao.Ma
 * @create: 2019-04-25 12:48
 **/
@EnableApolloConfig({
        ConfigConstants.NAMESPACE_APPLICATION,
        ConfigConstants.NAMESPACE_REGISTRY
})
@EnableAdminServer
@SpringBootApplication
public class EasyCloudAPMAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyCloudAPMAdminApplication.class, args);
    }
}
