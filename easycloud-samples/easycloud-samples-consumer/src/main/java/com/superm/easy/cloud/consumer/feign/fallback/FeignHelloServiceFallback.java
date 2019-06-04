package com.superm.easy.cloud.consumer.feign.fallback;

import com.superm.easy.cloud.consumer.feign.IFeignHelloService;
import com.superm.easy.cloud.consumer.domain.StudentInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-15 14:20
 **/
@Component
public class FeignHelloServiceFallback implements IFeignHelloService {
    @Override
    public String helloService(String name) {
        return "get error";
    }

    @Override
    public String helloService(String name, String password) {
        return "head error";
    }

    @Override
    public String helloService(StudentInfo studentInfo) {
        return "post error";
    }

    @Override
    public Map<String, Object> configStudent() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "fallback");
        map.put("age", -1);
        map.put("sex", "fallback");
        return map;
    }

    @Override
    public String helloName(String name) {
        return "hello fallback !!!";
    }

    @Override
    public List<String> generateUUID(String prefix, int limit) {
        return null;
    }

    @Override
    public String getInstanceId() {
        return "fallback";
    }
}
