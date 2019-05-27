# Intergrate Feign with Eureka client
`micro-weather-eureka-client-feign`
In localhost:8761 Eureka server dashboard, client status will be monitored.
## 集成Hystrix
micro-weather-eureka-client-feign -> micro-weather-eureka-client-feign-hystrix
## Environment
+ Gradle 4.0
+ Spring Boot 2.0.0.M3
+ Spring Cloud Netflix Eureka Client Finchley.M2
+ Spring Cloud Starter OpenFeign Finchley.M2
+ Spring Cloud Starter Netflix Hystrix Finchley.M2
## how to run
```
//Remember to start Redis first!
// Run eureka server on port 8761 
F:\webProject\springcloud\micro-weather-eureka-server\build\libs>java -jar micro-weather-eureka-server-1.0.0.jar --server.port=8761
F:\webProject\springcloud\msa-weather-city-eureka\build\libs>java -jar msa-weather-city-eureka-1.0.0.jar --server.port=8085
// run micro-weather-eureka-client-feign-hystrix on port 8080 from eclipse
Then see localhost:8080/cities
If it is run correctly, then see the city list json.
Then ctrl-c for city API micro-service in port 8085
Then can see City Data Server is down! message on localhost:8080/cities
```
