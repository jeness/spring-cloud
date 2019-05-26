#### 天气数据API msa-weather-data-server
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