package com.thzhima.jw.beans;

import java.io.Serializable;

public class Building implements Serializable{

	private Integer ID;
	private Double longitude;
	private Double latitude;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Building(Integer iD, Double longitude, Double latitude, String name) {
		super();
		ID = iD;
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Building [ID=" + ID + ", longitude=" + longitude + ", latitude=" + latitude + ", name=" + name + "]";
	}
	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
