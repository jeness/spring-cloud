# Weather Forcast System
## Environment
+ JDK 8
+ Gradle 4
+ Spring Boot Web Starter 2.0.0.M4
+ Apache HttpClient 4.5.3 (Request thrird party API to get weather info)
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