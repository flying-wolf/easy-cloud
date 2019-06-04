package com.superm.easy.cloud.consumer.controller;

import com.superm.easy.cloud.consumer.feign.IFeignHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-18 13:43
 **/
@RestController
@RequestMapping("/api/feign")
public class ApiController {
    @Autowired
    private IFeignHelloService feignHelloService;

    @GetMapping("/student")
    public Map<String, Object> configStudent() {
        return feignHelloService.configStudent();
    }

    @GetMapping("/{name}")
    public String helloName(@PathVariable(value = "name", required = false) String name) {
        return feignHelloService.helloName(name);
    }

    @GetMapping("/uid")
    public List<String> generateUUID(@RequestParam(value = "prefix", required = false) String prefix,
                                           @RequestParam(value = "limit", required = true) int limit) {
        return feignHelloService.generateUUID(prefix, limit);
    }

    @GetMapping("/instance-id")
    public String getInstanceId() {
        return feignHelloService.getInstanceId();
    }
}
