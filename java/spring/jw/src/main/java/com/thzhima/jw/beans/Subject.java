package com.thzhima.jw.beans;

import java.io.Serializable;

public class Subject implements Serializable{

	private Integer ID;
	private String name;
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
	@Override
	public String toString() {
		return "Subject [ID=" + ID + ", name=" + name + "]";
	}
	public Subject(Integer iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
