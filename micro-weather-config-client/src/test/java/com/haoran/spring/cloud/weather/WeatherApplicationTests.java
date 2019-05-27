package com.haoran.spring.cloud.weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {
	@Value("${auther}")  //云端的配置中心的配置文件内容
	private String auther;

	@Test
	public void contextLoads() {
		assertEquals("haoranyu.info", auther);
	}

}
