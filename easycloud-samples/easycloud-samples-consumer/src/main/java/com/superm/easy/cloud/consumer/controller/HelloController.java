package com.superm.easy.cloud.consumer.controller;

import com.superm.easy.cloud.consumer.feign.IFeignHelloService;
import com.superm.easy.cloud.consumer.domain.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-15 14:48
 **/
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @Autowired
    private IFeignHelloService feignHelloService;

    @GetMapping("/test")
    public String helloTest() {
        return "test success";
    }

    @GetMapping("/get")
    public String helloGet() {
        return feignHelloService.helloService("Super.M");
    }

    @GetMapping("/head")
    public String helloHead() {
        return feignHelloService.helloService("Super.M", "123456");
    }

    @GetMapping("/post")
    public String helloPost() {
        return feignHelloService.helloService(new StudentInfo("Super.M", "man", 35));
    }
}
