package com.thzhima.jw.beans;

import java.io.Serializable;
import java.sql.Date;

public class Times implements Serializable {

	private Integer ID;
	private String name;
	private Date startTime;
	private Date endTime;
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Times(Integer iD, String name, Date startTime, Date endTime) {
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
