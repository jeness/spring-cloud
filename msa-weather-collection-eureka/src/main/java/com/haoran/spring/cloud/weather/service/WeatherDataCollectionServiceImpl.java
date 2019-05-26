package com.haoran.spring.cloud.weather.service;

import java.util.concurrent.TimeUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
* @description weather data collection service
*/
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
	private static final String WEATHER_URl = "http://wthrcdn.etouch.cn/weather_mini?";
	private static final long TIME_OUT = 1800L; //1800s
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	
	@Override
	public void syncDataByCityId(String cityId) {
		String url = WEATHER_URl + "citykey=" + cityId;
		this.saveWeatherData(url);
		
	}
	
	/**
	 * 把天气数据放入缓存中
	 * Data write into cache
	 * @param url
	 */
	private void saveWeatherData(String url) {
		String key = url;
		String strBody = null;
		ObjectMapper mapper = new ObjectMapper();
		//WeatherResponse resp = null;
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

//		call service interface to getBody()
			ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);
			if(respString.getStatusCodeValue() == 200) {
				strBody = respString.getBody();
			}
			//Data write into cache
			ops.set(url, strBody, TIME_OUT, TimeUnit.SECONDS); //cache expire time
	}
	
	
}
