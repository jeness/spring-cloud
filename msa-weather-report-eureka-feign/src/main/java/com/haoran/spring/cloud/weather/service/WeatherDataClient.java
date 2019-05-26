package com.haoran.spring.cloud.weather.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.haoran.spring.cloud.weather.vo.City;
import com.haoran.spring.cloud.weather.vo.WeatherResponse;

/**
* @description weather data client
*/
@FeignClient("msa-weather-data-eureka")
public interface WeatherDataClient {
	@GetMapping("/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
