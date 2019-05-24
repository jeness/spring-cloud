package com.haoran.spring.cloud.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haoran.spring.cloud.weather.vo.Weather;
import com.haoran.spring.cloud.weather.vo.WeatherResponse;

/**
* @description weather report service implementation
*/
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
		return resp.getData();
	}

}
