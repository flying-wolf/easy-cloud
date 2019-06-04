package com.superm.easy.cloud.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-24 17:19
 **/
@RestController
@RequestMapping("/api/route")
public class RouteSampleController {

    @RequestMapping(value = "/weight/v1", produces = "text/plain;charset=UTF-8")
    public String weightV1() {
        return "V1";
    }

    @RequestMapping(value = "/weight/v2", produces = "text/plain;charset=UTF-8")
    public String weightV2() {
        return "V2";
    }

    @GetMapping("/limiter/{value}")
    public String limiter(@PathVariable("value") String value) {
        return String.format("limiter: %s", value);
    }
}
