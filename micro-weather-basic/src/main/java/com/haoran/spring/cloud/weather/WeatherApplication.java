package com.haoran.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
		 System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "|{}");
	}

}
