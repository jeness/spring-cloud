package com.haoran.spring.cloud.weather.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
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
	private static final String WEATHER_URl = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	private RestTemplate restTemplate;
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
		ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse resp = null;
		String strBody = null;
		
		if(respString.getStatusCodeValue() == 200) {
			strBody = respString.getBody();
		}
		
		try {
			resp = mapper.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resp;
	}

}
