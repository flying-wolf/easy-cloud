/*
package com.superm.easy.cloud.commons.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-05-28 17:44
 **//*

@Getter
@Setter
@Configuration
public class GlobalConfigProperties {
    @Value("my_server_id")
    private String myServerId;

    @Value("default.language")
    private String language;

    @Value("default.timezone")
    private String timezone;

    @Value("default.location")
    private String location;

    @Value("default.country")
    private String country;

}
*/
