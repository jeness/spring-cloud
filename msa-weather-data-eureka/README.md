#### 天气数据API msa-weather-data-eureka
get weather data from local Redis by cityId 
数据查询
```
GET /weather/cityId/{cityId}
GET /weather/cityName/{cityName}
```
## Environment
+ JDK 8
+ Gradle 4
+ Redis 3.2.100
+ Apache HttpClient 4.5.3 (Request thrird party API to get weather info)
+ Spring Boot Web Starter
+ Spring Boot Data Redis Starter
+ Spring Cloud Starter Netflix Eureka Client Finchley.M2
## build package and run micro service as client
On port 8083 and port 8084
```
//Remember to start Redis first!
F:\>cd F:\webProject\springcloud\msa-weather-data-eureka
F:\webProject\springcloud\msa-weather-data-eureka>gradle wrapper build
F:\webProject\springcloud\msa-weather-data-eureka>cd build/libs
F:\webProject\springcloud\msa-weather-data-eureka\build\libs>java -jar msa-weather-data-eureka-1.0.0.jar --server.port=8083
F:\webProject\springcloud\msa-weather-data-eureka\build\libs>java -jar msa-weather-data-eureka-1.0.0.jar --server.port=8084

```