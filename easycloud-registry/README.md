EasyCloud-Registry（注册中心）
----------

## 依赖组件

    Spring Cloud Netflix Eureka Server

## 简介

Eureka是基于REST（Representational State Transfer，代表性状态传输）的服务，主要用于AWS云中定位服务，以实现中间层服务器的负载平衡和故障转移。我们称这个服务为Eureka服务器。Eureka还带有一个基于Java的客户端组件，即Eureka客户端，它使与服务的交互更容易。

    客户端还有一个内置的负载均衡器，可以进行基本的循环负载均衡。在Netflix，一个更复杂的负载平衡器包装Eureka提供加权负载平衡的基础上的几个因素，如流量，资源使用情况，错误条件等，以提供卓越的弹性。

![Eureka架构图](../docs/EurekaArchitectureDiagram.png)

上图简要描述了Eureka的基本架构，由3个角色组成：

1、Eureka Server，提供服务注册和发现的服务端
- 服务端-没有存储，内存保持，每服务实例需要发送心跳去续约
- 客户端-在内存中缓存着eureka的注册信息，因此不必每请求到eureka查找服务
- eureka之间会做注册服务同步，从而保证状态一致，客户端只需访问一个eureka

2、Service Provider，服务提供方
- 会向Eureka Server做Register（服务注册）、Renew（服务续约）、Cancel（服务下线）等操作

3、Service Consumer，服务消费方
- 会向Eureka Server获取注册服务列表，并消费服务


## 开发指南

### 控制台查看

浏览器中打开`http://easycloud-registry.t.superm.com`，可以看到注册中心的一些信息，如目前注册的应用，应用上下线的记录。

![postman](.EurekaConsole.png)


### 客户端注册

Provider和Consumer注册到注册中心需要添加的eureka client包，并添加注册中心的配置, 如下

pom.xml

```
<!--注册中心-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

application.yml

```
eureka:
  client:
    service-url:
      defaultZone: http://${UNAME}:${PWD}@172.17.1.5:8761/eureka/,http://${UNAME}:${PWD}@172.17.1.8:8761/eureka/,http://${UNAME}:${PWD}@172.17.1.15:8761/eureka/
```

### 常用配置
