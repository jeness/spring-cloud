# Combine with thymeleaf-frontend
## Environment
+ JDK 8
+ Gradle 4
+ Redis 3.2.100
+ Apache HttpClient 4.5.3 (Request thrird party API to get weather info)
+ Spring Boot Web Starter
+ Spring Boot Data Redis Starter
+ Quartz Scheduler
+ Spring Boot Thymeleaf Starter 2.0.0.M4
+ Thymeleaf 3.0.7.RELEASE
+ Bootstrap 4.0.0-bata.2
## API
Get weather info by cityId: http://localhost:8080/report/cityId/101280501
```
GET /report/cityId/{cityId}
```