package com.thzhima.jw.beans;

import java.io.Serializable;
import java.sql.Date;

public class Times implements Serializable {

	private Integer ID;
	private String name;
	private Double startTime;
	private Double endTime;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getStartTime() {
		return startTime;
	}
	public void setStartTime(Double startTime) {
		this.startTime = startTime;
	}
	public Double getEndTime() {
		return endTime;
	}
	public void setEndTime(Double endTime) {
		this.endTime = endTime;
	}
	public Times(Integer iD, String name, Double startTime, Double endTime) {
		super();
		ID = iD;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Times() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Times [ID=" + ID + ", name=" + name + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
	
}
