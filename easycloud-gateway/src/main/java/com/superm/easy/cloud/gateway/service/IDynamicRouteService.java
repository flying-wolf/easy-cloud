package com.superm.easy.cloud.gateway.service;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

/**
 * @program: easy-cloud
 * @description: 动态路由服务接口
 * @author: Chao.Ma
 * @create: 2019-04-23 17:59
 **/
public interface IDynamicRouteService extends ApplicationEventPublisherAware {

    /**
     * @description: 添加路由
     * @param: [definition]
     * @return: java.lang.String
     * @author: Chao.Ma
     * @date: 2019/4/23
     **/
    String add(RouteDefinition definition);
    
    /**
     * @description: 更新路由 
     * @param: [definition]
     * @return: java.lang.String
     * @author: Chao.Ma
     * @date: 2019/4/23
     **/ 
    String update(RouteDefinition definition);
    
    /**
     * @description: 删除路由
     * @param: [id]
     * @return: reactor.core.publisher.Mono<org.springframework.http.ResponseEntity<java.lang.Object>>
     * @author: Chao.Ma
     * @date: 2019/4/23
     **/ 
    Mono<ResponseEntity<Object>> remove(String id);
}
