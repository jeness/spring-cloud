# Intergrate Feign with Eureka client
`micro-weather-eureka-client-feign`
In localhost:8761 Eureka server dashboard, client status will be monitored.
## Environment
+ Gradle 4.0
+ Spring Boot 2.0.0.M3
+ Spring Cloud Netflix Eureka Client Finchley.M2
+ Spring Cloud Starter OpenFeign Finchley.M2
## How to run
1. start eureka server `micro-weather-eureka-server`
2. start micro-service city data API `msa-weather-city-eureka`
On port 8081
```
cd F:\webProject\springcloud\msa-weather-city-eureka\build\libs
F:\webProject\springcloud\msa-weather-city-eureka\build\libs>java -jar msa-weather-city-eureka-1.0.0.jar --server.port=8081
```
3. start `micro-weather-eureka-client-feign`
