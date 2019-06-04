package com.superm.easy.cloud.apm.admin.config;

import de.codecentric.boot.admin.server.web.client.InstanceExchangeFilterFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-17 10:34
 **/
@Slf4j
@Configuration
public class GlobalConfiguration {
    @Bean
    public InstanceExchangeFilterFunction auditLog() {
        return (instance, request, next) -> {
            if (HttpMethod.DELETE.equals(request.method()) || HttpMethod.POST.equals(request.method())) {
                log.info("{} for {} on {}", request.method(), instance.getId(), request.url());
            }
            return next.exchange(request);
        };
    }
}
