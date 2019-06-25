package com.superm.easy.cloud.commons.constant;

import com.ctrip.framework.apollo.core.ConfigConsts;

/**
 * @program: easy-cloud
 * @description: 配置中心常量
 * @author: Chao.Ma
 * @create: 2019-04-25 14:44
 **/
public interface ConfigConstants extends ConfigConsts {

    String APOLLO_BOOTSTRAP_PREFIX = "apollo.bootstrap";

    String ENABLED = "enabled";

    /**
     * 配置中心命名空间-路由
     */
    String NAMESPACE_ROUTES = "routes.yml";

    /**
     * 配置中心命名空间-服务注册
     */
    String NAMESPACE_REGISTRY = "DEVBJ.REGISTER";

    /**
     * 配置中心命名空间-redis连接
     */
    String NAMESPACE_REDIS = "DEVBJ.REDIS";

    /**
     * 配置中心命名空间-kafka配置
     */
    String NAMESPACE_STREAM = "DEVBJ.STREAM";

    /**
     * 路由配置监听前缀
     */
    String ROUTES_CHANGE_LISTENER_PREFIX = "spring.cloud.gateway.";

}
