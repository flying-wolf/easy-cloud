package com.superm.easy.cloud.provider.controller;

import com.superm.easy.cloud.provider.config.StudentInfoProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-24 01:23
 **/
@RestController
@RequestMapping("/api/provider")
@RefreshScope
@EnableConfigurationProperties(StudentInfoProperties.class)
public class ProviderController {

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Autowired
    private StudentInfoProperties studentInfoProperties;

    @GetMapping("/config/student")
    public Map<String, Object> configStudent() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", studentInfoProperties.getName());
        map.put("sex", studentInfoProperties.getSex());
        map.put("age", studentInfoProperties.getAge());
        return map;
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable(value = "name", required = false) String name) {
        String helloStr = StringUtils.isNotEmpty(name) ? String.format("hello %s !!!", name) : null;
        return helloStr;
    }

    @GetMapping("/gen/uid")
    public List<String> generateUUID(@RequestParam(value = "prefix", required = false) String prefix,
                                     @RequestParam(value = "limit", required = true) int limit) {
        List<String> list = new ArrayList<>(10);
        String prefixStr = StringUtils.isNotEmpty(prefix) ? prefix.concat("-") : "";
        for (int i = 0; i < limit; i++) {
            list.add(prefixStr.concat(UUID.randomUUID().toString()));
        }
        return list;
    }

    @GetMapping("/header/print")
    public String printHeader(@RequestHeader(value = "X-TestHeader", required = false) String testHeader) {
        return StringUtils.isNotEmpty(testHeader) ? "X-TestHeader:"+testHeader : "X-TestHeader:empty";
    }

    @GetMapping("/get/instance-id")
    public String getInstanceId() {
        return instanceId;
    }
}
