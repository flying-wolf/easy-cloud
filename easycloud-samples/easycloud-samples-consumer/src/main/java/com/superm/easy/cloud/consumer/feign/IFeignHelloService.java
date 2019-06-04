package com.superm.easy.cloud.consumer.feign;

import com.superm.easy.cloud.consumer.config.GlobalFeignConfig;
import com.superm.easy.cloud.consumer.feign.fallback.FeignHelloServiceFallback;
import com.superm.easy.cloud.consumer.domain.StudentInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Component("feignHelloService")
@FeignClient(value = "easycloud-provider", fallback = FeignHelloServiceFallback.class, configuration = GlobalFeignConfig.class)
public interface IFeignHelloService {

    @RequestMapping(value="/api/demo/get",method= RequestMethod.GET)
    String helloService(@RequestParam("name") String name);

    @RequestMapping(value="/api/demo/header", method=RequestMethod.HEAD)
    String helloService(@RequestHeader("name") String name,
                        @RequestHeader("password") String password);

    @RequestMapping(value="/api/demo/post", method=RequestMethod.POST)
    String helloService(@RequestBody StudentInfo studentInfo);

    @GetMapping("/api/provider/config/student")
    Map<String, Object> configStudent();

    @GetMapping("/api/provider/hello/{name}")
    String helloName(@PathVariable(value = "name", required = false) String name);

    @GetMapping("/api/provider/gen/uid")
    List<String> generateUUID(@RequestParam(value = "prefix", required = false) String prefix,
                              @RequestParam(value = "limit", required = true) int limit);

    @GetMapping("/api/provider/get/instance-id")
    String getInstanceId();
}
