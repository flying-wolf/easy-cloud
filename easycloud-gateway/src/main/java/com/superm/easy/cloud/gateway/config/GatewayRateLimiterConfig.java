package com.superm.easy.cloud.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-24 12:00
 **/
@Component
public class GatewayRateLimiterConfig {

    /**
     * @description: IP 限流
     * @param: []
     * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     * @author: Chao.Ma
     * @date: 2019/4/24
     **/
//    @Bean(name = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    /**
     * @description: 用户 限流
     * @param: []
     * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     * @author: Chao.Ma
     * @date: 2019/4/24
     **/
//    @Bean(name = "userKeyResolver")
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }

    /**
     * @description: 接口限流
     * @param: []
     * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     * @author: Chao.Ma
     * @date: 2019/4/24
     **/
//    @Bean(name = "apiKeyResolver")
    public KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

    @Bean(name = RemoteAddrKeyResolver.BEAN_NAME)
    public RemoteAddrKeyResolver remoteAddrKeyResolver() {
        return new RemoteAddrKeyResolver();
    }


    final class RemoteAddrKeyResolver implements KeyResolver {

        public static final String BEAN_NAME = "remoteAddrKeyResolver";

        @Override
        public Mono<String> resolve(ServerWebExchange exchange) {
            return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        }
    }
}
