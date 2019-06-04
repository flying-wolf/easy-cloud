package com.superm.easy.cloud.provider.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-09 10:33
 **/
@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "student")
public class StudentInfoProperties {
    private String name;
    private int age;
    private String sex;
}
