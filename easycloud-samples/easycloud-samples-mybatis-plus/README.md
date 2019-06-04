MyBatis-Plus Code Generator Sample（代码生成器样例）
----------

## 依赖组件

    mybatis-plus-boot-starter
    mybatis-plus-generator
    velocity-engine-core
    mysql-connector-java

## 简介

AutoGenerator 是 MyBatis-Plus 的代码生成器，通过 AutoGenerator 可以快速生成 Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码，极大的提升了开发效率。


## 使用指南

### 依赖

pom.xml

```
<!-- 快速构建 -->
<dependency>
    <groupId>com.superm.easy.cloud</groupId>
    <artifactId>easycloud-starter-quick</artifactId>
</dependency>

<!-- 数据源相关依赖(mybatis-plus,generator,mysql-connector,druid,velocity) -->
<dependency>
    <groupId>com.superm.easy.cloud</groupId>
    <artifactId>easycloud-starter-datasource</artifactId>
</dependency>

<!-- 公共模块，包含代码生成工具 -->
<dependency>
    <groupId>com.superm.easy.cloud</groupId>
    <artifactId>easycloud-commons</artifactId>
</dependency>

<!-- POJO构建工具 -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>compile</scope>
    <optional>true</optional>
</dependency>
```

### 配置

application.yml

```
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/dbName?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true
    username: xxx
    password: xxx
    
mybatis-plus:
  mapper-locations: classpath:/mapper/*.xml
  typeAliasesPackage: com.superm.easy.cloud.mybatisplus.demo.biz.entity
  global-config:
    id-type: 2
    field-strategy: 2
    db-column-underline: true
    refresh-mapper: true
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false
```

### 生成CODE

JUnit测试类
```java
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
                "com.superm.easy.cloud.mybatisplus.demo",//包名
                "biz",//模块
                "tb_device_info"//表
        );
    }
}
```

## 生成后的目录结构
```
main
├── java --代码目录
     ├── com.superm.easy.cloud.mybatisplus.demo --指定的包名
          ├── biz --指定的模块名
               ├── controller
                    └── DeviceInfoController.java
               ├── dao
                    └── IDeviceInfoDao.java
               ├── entity
                    └── DeviceInfo.java
               └── service
                    ├── impl
                         └── DeviceInfoServerImpl.java
                    ├── IDeviceInfoServer.java
          └── Application.java
└──resources -- 资源目录
    ├── mapper
        └── DeviceInfoMapper.xml    
    └── application.yml
	 
```