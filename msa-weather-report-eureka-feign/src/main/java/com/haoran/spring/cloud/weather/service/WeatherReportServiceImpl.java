package com.haoran.spring.cloud.weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haoran.spring.cloud.weather.vo.Forecast;
import com.haoran.spring.cloud.weather.vo.Weather;
import com.haoran.spring.cloud.weather.vo.WeatherResponse;

/**
* @description weather report service implementation
*/
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private WeatherDataClient weatherDataClient;

	
	@Override
	public Weather getDataByCityId(String cityId) {
		//change to micro service weather data API to implement
		//TODO 已完成由天气数据api （data）微服务来提供
		WeatherResponse resp = weatherDataClient.getDataByCityId(cityId);
		Weather data = resp.getData();
		
		return data;
		
	}

}
