# Intergrate with Eureka server
## Environment
+ JDK 8
+ Gradle 4
+ Spring Boot 2.0.0.M3
+ Spring Cloud Starter Netflix Eureka Server Finchley.M2
## Configuration
@EnableEurekaServer in `app.java`
server.port: 8761
## Client
```
msa-weather-collection-server -> msa-weather-collection-eureka  //port=8081
msa-weather-data-server -> msa-weather-data-eureka
msa-weather-city-server -> msa-weather-city-eureka
msa-weather-report-server -> msa-weather-report-eureka
```
Start 4 eureka client in 4 different port:
```
//Remember to start Redis first!
F:\webProject\springcloud\msa-weather-collection-eureka>gradle wrapper build
F:\webProject\springcloud\msa-weather-collection-eureka>cd build/libs
F:\webProject\springcloud\msa-weather-collection-eureka\build\libs>java -jar msa-weather-collection-eureka-1.0.0.jar --server.port=8081
F:\webProject\springcloud\msa-weather-collection-eureka\build\libs>java -jar msa-weather-collection-eureka-1.0.0.jar --server.port=8082

F:\>cd F:\webProject\springcloud\msa-weather-data-eureka
F:\webProject\springcloud\msa-weather-data-eureka>gradle wrapper build
F:\webProject\springcloud\msa-weather-data-eureka>cd build/libs
F:\webProject\springcloud\msa-weather-data-eureka\build\libs>java -jar msa-weather-data-eureka-1.0.0.jar --server.port=8083
F:\webProject\springcloud\msa-weather-data-eureka\build\libs>java -jar msa-weather-data-eureka-1.0.0.jar --server.port=8084

F:\webProject\springcloud\msa-weather-report-eureka>gradle wrapper build
F:\webProject\springcloud\msa-weather-report-eureka>cd build/libs
F:\webProject\springcloud\msa-weather-report-eureka\build\libs>java -jar msa-weather-report-eureka-1.0.0.jar --server.port=8087
F:\webProject\springcloud\msa-weather-report-eureka\build\libs>java -jar msa-weather-report-eureka-1.0.0.jar --server.port=8088

F:\webProject\springcloud\msa-weather-city-eureka>gradle wrapper build
F:\webProject\springcloud\msa-weather-city-eureka>cd build/libs
F:\webProject\springcloud\msa-weather-city-eureka\build\libs>java -jar msa-weather-city-eureka-1.0.0.jar --server.port=8085
F:\webProject\springcloud\msa-weather-city-eureka\build\libs>java -jar msa-weather-city-eureka-1.0.0.jar --server.port=8086
```

