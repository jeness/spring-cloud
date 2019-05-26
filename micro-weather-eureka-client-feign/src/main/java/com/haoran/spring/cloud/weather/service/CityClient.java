package com.haoran.spring.cloud.weather.service;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
* @description city client
*/

@FeignClient("msa-weather-city-eureka")
public interface CityClient {
	@GetMapping("/cities")
	String listCity();
}
