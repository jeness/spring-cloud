package com.haoran.spring.cloud.weather.vo;

import java.io.Serializable;

/**
* @description weather in the future
* [{"date":"22日星期三","high":"高温 29℃","fengli":"<![CDATA[<3级]]>","low":"低温 23℃","fengxiang":"无持续风向","type":"小雨"}
*/
public class Forecast implements Serializable{

	private static final long serialVersionUID = 1L;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getFengli() {
		return fengli;
	}
	public void setFengli(String fengli) {
		this.fengli = fengli;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getFengxiang() {
		return fengxiang;
	}
	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String date;
	private String high;
	private String fengli;
	private String low;
	private String fengxiang;
	private String type;
}
