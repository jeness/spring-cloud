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