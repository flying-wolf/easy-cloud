package com.superm.easy.cloud.provider.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-18 03:03
 **/
@Slf4j
@Component
public class TestScheduling {
    @Scheduled(fixedRate = 50000)
    public void test() {
        System.out.println("定时任务："+System.currentTimeMillis());
        log.info("定时任务："+System.currentTimeMillis());
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void updateTask() {
        log.info("定时任务："+System.currentTimeMillis());
    }
}
