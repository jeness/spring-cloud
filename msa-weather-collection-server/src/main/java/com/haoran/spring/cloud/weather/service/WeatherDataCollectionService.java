package com.haoran.spring.cloud.weather.service;
/**
* @description Weather Data Collection Service
*/
public interface WeatherDataCollectionService {
	/**
	 * 根据城市ID同步天气
	 * @param cityId
	 */
	void syncDataByCityId(String cityId);
}
