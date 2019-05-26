# MicroService天气数据采集 msa-weather-collection-eureka
Weather Data Collection Service
数据采集、数据存储
## Environment
+ JDK 8
+ Gradle 4
+ Redis 3.2.100
+ Apache HttpClient 4.5.3 (Request thrird party API to get weather info)
+ Spring Boot Web Starter
+ Spring Boot Data Redis Starter
+ Quartz Scheduler
+ Spring Cloud Starter Netflix Eureka Client Finchley.M2
## build package and run micro service as client
On port 8081 and port 8082
```
//Remember to start Redis first!
F:\webProject\springcloud\msa-weather-collection-eureka>gradle wrapper build
F:\webProject\springcloud\msa-weather-collection-eureka>cd build/libs
F:\webProject\springcloud\msa-weather-collection-eureka\build\libs>java -jar msa-weather-collection-eureka-1.0.0.jar --server.port=8081
F:\webProject\springcloud\msa-weather-collection-eureka\build\libs>java -jar msa-weather-collection-eureka-1.0.0.jar --server.port=8082
```
## Achievement
Get weather info by cityId: http://wthrcdn.etouch.cn/weather_mini?citykey=101280601.
And store into Redis.
```
{
  "data": {
    "yesterday": {
      "date": "23日星期四",
      "high": "高温 29℃",
      "fx": "无持续风向",
      "low": "低温 25℃",
      "fl": "<![CDATA[<3级]]>",
      "type": "多云"
    },
    "city": "深圳",
    "forecast": [
      {
        "date": "24日星期五",
        "high": "高温 29℃",
        "fengli": "<![CDATA[<3级]]>",
        "low": "低温 25℃",
        "fengxiang": "无持续风向",
        "type": "阵雨"
      },
      {
        "date": "25日星期六",
        "high": "高温 30℃",
        "fengli": "<![CDATA[<3级]]>",
        "low": "低温 26℃",
        "fengxiang": "无持续风向",
        "type": "雷阵雨"
      },
      {
        "date": "26日星期天",
        "high": "高温 30℃",
        "fengli": "<![CDATA[<3级]]>",
        "low": "低温 26℃",
        "fengxiang": "无持续风向",
        "type": "雷阵雨"
      },
      {
        "date": "27日星期一",
        "high": "高温 31℃",
        "fengli": "<![CDATA[<3级]]>",
        "low": "低温 25℃",
        "fengxiang": "无持续风向",
        "type": "阵雨"
      },
      {
        "date": "28日星期二",
        "high": "高温 29℃",
        "fengli": "<![CDATA[<3级]]>",
        "low": "低温 24℃",
        "fengxiang": "无持续风向",
        "type": "雷阵雨"
      }
    ],
    "ganmao": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。",
    "wendu": "27"
  },
  "status": 1000,
  "desc": "OK"
}
```