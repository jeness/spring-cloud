package com.haoran.spring.cloud.weather.service;

import java.util.List;

import com.haoran.spring.cloud.weather.vo.City;

/**
* @description City Data Service
*/
public interface CityDataService {
	List<City> ListCity() throws Exception;
}
