package com.haoran.spring.cloud.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haoran.spring.cloud.weather.service.CityDataService;
import com.haoran.spring.cloud.weather.vo.City;

@RestController
@RequestMapping("/cities")
public class CityController {
	@Autowired
	private CityDataService cityDataService;

	@GetMapping
	public List<City> listCity() throws Exception {
		return cityDataService.listCity();
	}
}
