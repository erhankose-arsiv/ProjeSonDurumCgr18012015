package org.tutev.cagri.web.controller;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CurrentWeather")
public class CurrentWeather {
	
	@XmlElement(name="Location")
	String Location;
	@XmlElement(name="Time")
	Date Time;
	@XmlElement(name="Wind")
	String Wind;
	@XmlElement(name="Visibility")
	String Visibility;
	@XmlElement(name="SkyConditions")
	String SkyConditions;
	@XmlElement(name="Temperature")
	String Temperature;
	@XmlElement(name="DewPoint")
	String DewPoint;
	@XmlElement(name="RelativeHumidity")
	String RelativeHumidity;
	@XmlElement(name="Pressure")
	String Pressure;
	@XmlElement(name="Status")
	String Status;

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}

	public String getWind() {
		return Wind;
	}

	public void setWind(String wind) {
		Wind = wind;
	}

	public String getVisibility() {
		return Visibility;
	}

	public void setVisibility(String visibility) {
		Visibility = visibility;
	}

	public String getSkyConditions() {
		return SkyConditions;
	}

	public void setSkyConditions(String skyConditions) {
		SkyConditions = skyConditions;
	}

	public String getTemperature() {
		return Temperature;
	}

	public void setTemperature(String temperature) {
		Temperature = temperature;
	}

	public String getDewPoint() {
		return DewPoint;
	}

	public void setDewPoint(String dewPoint) {
		DewPoint = dewPoint;
	}

	public String getRelativeHumidity() {
		return RelativeHumidity;
	}

	public void setRelativeHumidity(String relativeHumidity) {
		RelativeHumidity = relativeHumidity;
	}

	public String getPressure() {
		return Pressure;
	}

	public void setPressure(String pressure) {
		Pressure = pressure;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
