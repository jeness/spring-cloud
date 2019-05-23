package com.haoran.spring.cloud.weather.vo;

import java.io.Serializable;

/**
* @description weather of yesterday
*/
//"date":"21日星期二","high":"高温 28℃","fx":"无持续风向","low":"低温 24℃","fl":"<![CDATA[<3级]]>","type":"多云"
public class Yesterday implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String date;
	private String high;
	private String low;
	private String fl;
	private String fx;
	private String type;
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
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
