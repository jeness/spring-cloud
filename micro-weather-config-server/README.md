# Intergrate with Eureka client
`micro-weather-config-server`
client run at localhost:8080.
In localhost:8761 Eureka server dashboard, client status will be monitored.
## Environment
+ JDK 8
+ Gradle 4
+ Spring Boot 2.0.0.M3
+ Spring Cloud Starter Netflix Eureka Client Finchley.M2
+ Spring Cloud Config Server Finchley.M2
# 微服务集中化配置
## 为什么微服务需要集中化配置
+ 微服务数量多，配置多
+ 手工管理配置繁琐
## 配置分类
### 按配置的来源来分：
+ 主要有源代码、文件、数据库连接、远程调用等
+ 开发环境、测试环境、预发布环境、生产环境
### 按配置的集成阶段划分
+ 编译时、打包时和运行时
### 按配置的加载方式划分
+ 启动加载和动态加载
## 配置中心的要求
+ 面向可配置的编码，避免硬编码，eg. 数据库的分页大小
+ 隔离性，生产环境和开发环境的配置不一样的，要隔离
+ 一致性，相同的部署环境下，instance一样
+ 集中化配置，应用的配置要能够在统一的平台上远程管理
## Spring Cloud Config
Spring Cloud Starter Netflix Eureka Client Finchley.M2
+ Config server: 使用git
+ Config Client
### 集成Config Server:
```
micro-weather-eureka-client -> micro-weather-config-server
```
### Dependency
```
dependencies {
    // Spring Cloud Config Server
        compile('org.springframework.cloud:spring-cloud-config-server')
}
```
### Application.java 
Add 注解：@EnableConfigServer
### application.properties change to
```
spring.application.name: micro-weather-config-server
server.port=8888

eureka.client.serviceUrl.defaultZone: http://localhost:8761/eureka/

spring.cloud.config.server.git.uri=https://github.com/jeness/spring-cloud
spring.cloud.config.server.git.searchPaths=config-repo   //git repo中放 config文件的文件夹名字
```
visit: http://localhost:8888/auther/dev, then can see
```
{
"name": "auther",
"profiles": [
"dev"
],
"label": null,
"version": "db4c0c75db4fae0e6576eefc7ec4b9b04ed0b3c5",
"state": null,
"propertySources": []
}
```