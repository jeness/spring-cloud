package com.haoran.spring.cloud.weather.service;

import com.haoran.spring.cloud.weather.vo.Weather;

/**
* @description Weather Report Service
*/
public interface WeatherReportService {
	/**
	 * get weather data by city id
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);
}
