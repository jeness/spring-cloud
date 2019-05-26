# 城市数据API msa-weahter-city-eureka
数据查询
## Environment
+ JDK 8
+ Gradle 4
+ Spring Boot Web Starter
+ Spring Cloud Starter Netflix Eureka Client Finchley.M2
## API
```
GET localhost:8080/cities
```
## build package and run micro service as client
On port 8085 and port 8086
```
//Remember to start Redis first!
F:\webProject\springcloud\msa-weather-city-eureka>gradle wrapper build
F:\webProject\springcloud\msa-weather-city-eureka>cd build/libs
F:\webProject\springcloud\msa-weather-city-eureka\build\libs>java -jar msa-weather-city-eureka-1.0.0.jar --server.port=8085
F:\webProject\springcloud\msa-weather-city-eureka\build\libs>java -jar msa-weather-city-eureka-1.0.0.jar --server.port=8086
```