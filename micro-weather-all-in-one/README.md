# Weather Forcast System
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
+ Bootstrap 4.0.0
# 1. Basic Weather Forcast System 
`micro-weather-basic`
1. Get weather info by cityId (http://wthrcdn.etouch.cn/weather_mini?citykey=101010100)
```
GET localhost:8080/weather/cityId/101010100
```
```
{
    "data": {
        "city": "北京",
        "aqi": null,
        "ganmao": "各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。",
        "wendu": "20",
        "yesterday": {
            "date": "22日星期三",
            "high": "高温 35℃",
            "low": "低温 17℃",
            "fl": "<![CDATA[3-4级]]>",
            "fx": "西南风",
            "type": "晴"
        },
        "forecast": [
            {
                "date": "23日星期四",
                "high": "高温 35℃",
                "fengli": "<![CDATA[3-4级]]>",
                "low": "低温 17℃",
                "fengxiang": "西南风",
                "type": "晴"
            },
            {
                "date": "24日星期五",
                "high": "高温 37℃",
                "fengli": "<![CDATA[<3级]]>",
                "low": "低温 21℃",
                "fengxiang": "南风",
                "type": "晴"
            },
            {
                "date": "25日星期六",
                "high": "高温 35℃",
                "fengli": "<![CDATA[3-4级]]>",
                "low": "低温 21℃",
                "fengxiang": "南风",
                "type": "多云"
            },
            {
                "date": "26日星期天",
                "high": "高温 35℃",
                "fengli": "<![CDATA[<3级]]>",
                "low": "低温 22℃",
                "fengxiang": "南风",
                "type": "多云"
            },
            {
                "date": "27日星期一",
                "high": "高温 24℃",
                "fengli": "<![CDATA[3-4级]]>",
                "low": "低温 17℃",
                "fengxiang": "北风",
                "type": "小雨"
            }
        ]
    },
    "status": 1000,
    "desc": "OK"
}
```
2. Get weather info by cityName (http://wthrcdn.etouch.cn/weather_mini?city=深圳)
```
GET localhost:8080/weather/cityName/深圳
```
```
{
    "data": {
        "city": "深圳",
        "aqi": null,
        "ganmao": "天气转凉，空气湿度较大，较易发生感冒，体质较弱的朋友请注意适当防护。",
        "wendu": "25",
        "yesterday": {
            "date": "22日星期三",
            "high": "高温 29℃",
            "low": "低温 23℃",
            "fl": "<![CDATA[<3级]]>",
            "fx": "无持续风向",
            "type": "小雨"
        },
        "forecast": [
            {
                "date": "23日星期四",
                "high": "高温 29℃",
                "fengli": "<![CDATA[<3级]]>",
                "low": "低温 23℃",
                "fengxiang": "无持续风向",
                "type": "小雨"
            },
            {
                "date": "24日星期五",
                "high": "高温 28℃",
                "fengli": "<![CDATA[<3级]]>",
                "low": "低温 24℃",
                "fengxiang": "无持续风向",
                "type": "中雨"
            },
            {
                "date": "25日星期六",
                "high": "高温 29℃",
                "fengli": "<![CDATA[<3级]]>",
                "low": "低温 25℃",
                "fengxiang": "无持续风向",
                "type": "大到暴雨"
            },
            {
                "date": "26日星期天",
                "high": "高温 30℃",
                "fengli": "<![CDATA[<3级]]>",
                "low": "低温 25℃",
                "fengxiang": "无持续风向",
                "type": "阵雨"
            },
            {
                "date": "27日星期一",
                "high": "高温 31℃",
                "fengli": "<![CDATA[<3级]]>",
                "low": "低温 26℃",
                "fengxiang": "无持续风向",
                "type": "阵雨"
            }
        ]
    },
    "status": 1000,
    "desc": "OK"
}
```
# 2. 使用Redis来提升Weather forcast service app的并发访问能力
前提：Weather forcast service app 能实现简单的天气查询
## 为什么使用Redis （目前的系统存在以下问题）
1. app作为relay的中介，用户调用中介，中介调用上游API，可能产生延时delay
2. 上游第三方API有调用次数和频率的限制，也有有承接调用能力的限制，对上游API调用次数过多，使得API的负载过大
+ Redis是基于内存的缓存系统，响应速度快，可以解决以上两个问题
## 原因有两个：
1. 减轻访问上游API带来的延时问题，确保及时响应
2. 减少（上游api的）服务调用，减轻天气接口的负担，提高并发访问量
+ 天气不需要实时更新，定时更新数据即可（例如半小时更新一次），这种场景非常适合应用Redis缓存

# 3.quartz scheduler 定时获取天气数据
Every 1800 seconds | 30 mins, synchronize weather data(excute WeatherDataServiceImpl on cities in CityList.xml) once.

# 4.Combine with thymeleaf-frontend
## API
Get weather info by cityId: http://localhost:8080/report/cityId/101280501
```
GET /report/cityId/{cityId}
```
# 微服务
## 单块架构的优缺点
->请求
用户 表示层 业务层 数据访问层 数据库
<-响应
### 优点
+ 功能划分清楚
+ 层次关系良好
+ 每一层独立
+ 部署简单
+ 技术单一
+ 用人成本低
### 缺点
+ 功能仍然太大：数据同步，缓存，UI
+ 升级风险高：升级其中一个服务，不得不要升级整个系统
+ 维护成本增加：不是一个人来维护，一个人无法handle和理解代码
+ 交付周期变长：四个功能全完成，才能交付，不能单个交付
+ 可伸缩性差： 本来只要扩展数据采集一个功能的，但是因为是一个整体，就不得不把所有功能都扩展
+ 监控困难：进程、IO 不能再细粒度了
因为有这些缺点，所以单体架构转向发展微服务架构
## 如何将单块架构转为微服务架构
soa：系统功能打散，一个功能对应一个微服务
APP可以拆分为以下的服务：城市数据 天气数据 数据同步 天气数据预报
## 微服务架构的设计原则
+ 拆分足够微
+ 轻量级通信
+ 领域驱动原则：
帮助团队理清数据的边界，搞清上下文 不同的领域： 城市数据采集、天气数据采集，数据同步，
+ 单一职责原则
+ DevOps及两个披萨
+ 不限于技术栈
## 怎么设计微服务系统
+ 服务拆分
+ 服务注册： 服务注册中心（表），服务启动，则在中心注册，广播状态
+ 服务发现：调用服务的接口获取名称
+ 服务消费：服务调用的称为消费者，被调用的服务称为供应商
+ 统一入口
+ 配置管理
+ 熔断机制：高并发无法响应请求，熔断部分服务，避免整个系统崩溃
+ 自动扩展：当overload出现，10个服务扩展到20个，比较复杂
### DDD 拆分服务
#### 天气数据采集 msa-weather-collection-server
数据采集、数据存储
#### 天气数据API msa-weather-data-server
数据查询
```
GET /weather/cityId/{cityId}
GET /weather/cityName/{cityName}
```
#### 天气预报 msa-weather-report-server
数据展示
```
GET /report/cityId/{cityId}
```
#### 城市数据API msa-weahter-city-server
数据查询
```
GET /cities
```
#### Storage 存储设计
Redis（NoSQL） XML
