package com.haoran.spring.cloud.weather.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.haoran.spring.cloud.weather.service.CityDataService;
import com.haoran.spring.cloud.weather.service.WeatherDataService;
import com.haoran.spring.cloud.weather.service.WeatherDataServiceImpl;
import com.haoran.spring.cloud.weather.vo.City;

/**
* @description Weather Data Sync Job
*/
public class WeatherDataSyncJob extends QuartzJobBean {

	private static Logger Logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
	
	@Autowired
	private CityDataService cityDataService;
	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		Logger.info("Weather Data Sync Job, start!");
		
		//获取城市ID列表
		List<City> cityList = null;
		
		try {
			cityList = cityDataService.listCity();
		} catch (Exception e) {
			Logger.error("Exception!" + e);
//			e.printStackTrace();
		}
		
		//遍历城市ID获取天气
		for(City city:cityList) {
			String cityId = city.getCityId();
			Logger.info("Weather Data Sync Job, cityId:" + cityId);
			
			weatherDataService.syncDateByCityId(cityId);
		}
		Logger.info("Weather Data Sync Job, end!");

	}

}
