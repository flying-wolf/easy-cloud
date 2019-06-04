package com.superm.easy.cloud.mybatisplus.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-05-13 16:33
 **/
@Configuration
@MapperScan("com.superm.easy.cloud.mybatisplus.demo.biz.dao")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
