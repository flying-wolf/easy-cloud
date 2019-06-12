package com.superm.easy.cloud.auth.authorization.generator;

import com.superm.easy.cloud.commons.generator.MyBatisCodeGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-05-14 15:06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(MyBatisCodeGenerator.class)
public class MyBatisGeneratorTests {

    @Resource
    private MyBatisCodeGenerator generator;

    @Test
    public void testCodeGenerator() {
        //代码生成
        generator.generateByTables(
                "com.superm.easy.cloud.auth.authorization",//包名
                "",
                "users", "roles"//表
        );
    }
}
