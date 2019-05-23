package com.haoran.spring.cloud.weather.service;

import com.haoran.spring.cloud.weather.vo.WeatherResponse;

/**
* @description weather data service
*/
public interface WeatherDataService {
	/**
	 * 根据城市ID查询天气数据
	 * @param cityId
	 * @return
	 * */
	WeatherResponse getDataByCityId(String cityId);
	/**
	 * 根据城市名称查询天气数据
	 * @param cityName
	 * @return
	 * */
	WeatherResponse getDataByCityName(String cityName);
	
	/**
	 * 根据城市ID来同步天气
	 * @param cityId
	 */
	void syncDateByCityId(String cityId);
}
