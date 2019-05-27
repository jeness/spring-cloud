### Intergrate Config Client
一个eureka的client
```
micro-weather-eureka-client -> micro-weather-config-client
```
## Environment
+ JDK 8
+ Gradle 4
+ Spring Boot 2.0.0.M3
+ Spring Cloud Starter Netflix Eureka Client Finchley.M2
+ Spring Cloud Config Client Finchley.M2
### Dependency
```
dependencies {
    // Spring Cloud Config Client
        compile('org.springframework.cloud:spring-cloud-config-client')
}
```
### Application.java 
Add 注解：@EnableConfigClient
### change appplication.properties
```
spring.application.name: micro-weather-config-client
server.port=8888

eureka.client.serviceUrl.defaultZone: http://localhost:8761/eureka/

spring.cloud.config.profile=dev
spring.cloud.config.uri=http://localhost:8888/
```
### how to run
1. run `micro-weather-eureka-server`
2. run `micro-weather-config-server`
3. run unit test in `micro-weather-config-client` to see the context of files in github properties is retrieved into config client or not
### 配置中心的文件的命名规则
```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```