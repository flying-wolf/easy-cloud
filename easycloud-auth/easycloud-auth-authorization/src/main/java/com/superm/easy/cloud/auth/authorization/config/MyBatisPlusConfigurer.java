package com.superm.easy.cloud.auth.authorization.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.superm.easy.cloud.commons.handler.MetaHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: family-monitor-server
 * @description:
 * @author: Chao.Ma
 * @create: 2019-05-14 17:13
 **/
@Configuration
@EnableTransactionManagement
@Import(MetaHandler.class)
@MapperScan("com.superm.easy.cloud.auth.authorization.dao")
public class MyBatisPlusConfigurer {

    @Autowired
    @Bean
    public GlobalConfig globalConfig(MetaHandler metaHandler) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(metaHandler);
        return globalConfig;
    }

    /**
     * SQL执行效率插件
     */
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor().setFormat(true).setMaxTime(100);
    }

    /**
     * 分页插件
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
