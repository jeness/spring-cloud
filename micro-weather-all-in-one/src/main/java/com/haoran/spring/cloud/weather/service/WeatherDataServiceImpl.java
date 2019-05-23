package com.haoran.spring.cloud.weather.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haoran.spring.cloud.weather.vo.WeatherResponse;

/**
* @description WeatherDataService 实现
*/
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	private static Logger Logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
	private static final String WEATHER_URl = "http://wthrcdn.etouch.cn/weather_mini?";
	
	private static final long TIME_OUT = 1800L; //1800s
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		// TODO Auto-generated method stub
		String url = WEATHER_URl + "citykey="+ cityId;
		return this.doGetWeather(url);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		// TODO Auto-generated method stub
		String url = WEATHER_URl + "city=" + cityName;
		return this.doGetWeather(url);
	}
	
	private WeatherResponse doGetWeather(String url) {
		String key = url;
		String strBody = null;
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse resp = null;
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
//		先查缓存，缓存有的取缓存中的数据
		if(stringRedisTemplate.hasKey(key)){
			Logger.info("Redis has data");
			strBody = ops.get(key);
		}
		else {
//			缓存没有，再调用服务接口来获取
			Logger.info("Redis doesn't have data");
			ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);
			if(respString.getStatusCodeValue() == 200) {
				strBody = respString.getBody();
			}
			//数据写入缓存
			ops.set(url, strBody, TIME_OUT, TimeUnit.SECONDS); //缓存失效时间
		}
		try {
			resp = mapper.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
//			e.printStackTrace();
			Logger.info("Error", e);
		}
		return resp;
	}

}
