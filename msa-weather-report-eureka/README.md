# 天气预报 msa-weather-report-eureka
数据展示
## Environment
+ JDK 8
+ Gradle 4
+ Spring Boot Web Starter
+ Thymeleaf 3.0.7.RELEASE
+ Bootstrap 4.0.0-bata.2
+ Spring Cloud Starter Netflix Eureka Client Finchley.M2
## build package and run micro service as client
On port 8087 and port 8088
```
//Remember to start Redis first!
F:\webProject\springcloud\msa-weather-report-eureka>gradle wrapper build
F:\webProject\springcloud\msa-weather-report-eureka>cd build/libs
F:\webProject\springcloud\msa-weather-report-eureka\build\libs>java -jar msa-weather-report-eureka-1.0.0.jar --server.port=8087
F:\webProject\springcloud\msa-weather-report-eureka\build\libs>java -jar msa-weather-report-eureka-1.0.0.jar --server.port=8088
```
## API
Get weather info by cityId: http://localhost:8080/report/cityId/101280501
```
GET /report/cityId/{cityId}
```