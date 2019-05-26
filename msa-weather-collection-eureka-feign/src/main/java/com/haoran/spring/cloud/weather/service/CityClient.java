package com.haoran.spring.cloud.weather.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.haoran.spring.cloud.weather.vo.City;

/**
* @description
*/
@FeignClient("msa-weather-city-eureka")
public interface CityClient {
	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
