package com.haoran.spring.cloud.weather.job;

import java.util.ArrayList;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.haoran.spring.cloud.weather.service.CityClient;
import com.haoran.spring.cloud.weather.service.WeatherDataCollectionService;
import com.haoran.spring.cloud.weather.service.WeatherDataCollectionServiceImpl;

import com.haoran.spring.cloud.weather.vo.City;

/**
* @description Weather Data Sync Job
*/
public class WeatherDataSyncJob extends QuartzJobBean {

	private static Logger Logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);
	
	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	
	@Autowired
	private CityClient cityClient;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		Logger.info("Weather Data Sync Job, start!");
		
		//acquire city ID list
		//TODO change to use city data API micro service to provide data
		List<City> cityList = null;
		
		try {
			//change to use city data API micro service to provide data
			cityList = cityClient.listCity();
		} catch (Exception e) {
			Logger.error("Exception!" + e);
//			e.printStackTrace();
		}
		
		//遍历城市ID获取天气
		for(City city:cityList) {
			String cityId = city.getCityId();
			Logger.info("Weather Data Sync Job, cityId:" + cityId);
			
			weatherDataCollectionService.syncDataByCityId(cityId);
		}
		Logger.info("Weather Data Sync Job, end!");

	}

}
