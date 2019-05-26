package com.haoran.spring.cloud.weather.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.haoran.spring.cloud.weather.service.WeatherReportService;
import com.haoran.spring.cloud.weather.vo.City;
import com.haoran.spring.cloud.weather.vo.WeatherResponse;
/**
* @description Weather Controller
*/
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	
	private static Logger Logger = LoggerFactory.getLogger(WeatherReportController.class);
	

	@Autowired
	private WeatherReportService weatherReportService;
	
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		//TODO 改为由成熟数据API微服务来提供数据
		//TODO change to use city data API micro service to provide data
		List<City> cityList = null;
		
		try {
			//TODO  change to use city data API micro service to provide data
			cityList = new ArrayList<>();
			City city = new City();
			city.setCityId("101280601");
			city.setCityName("深圳");
			cityList.add(city);
		} catch (Exception e) {
			Logger.error("Exception!" + e);
//			e.printStackTrace();
		}
		model.addAttribute("title", "我的天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report", "reportModel", model);
	}
	
}
