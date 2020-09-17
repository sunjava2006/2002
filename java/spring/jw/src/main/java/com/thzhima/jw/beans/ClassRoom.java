package com.thzhima.jw.beans;

import java.io.Serializable;

public class ClassRoom implements Serializable{

	private Integer ID;
	private String name;
	private Building building;
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
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public ClassRoom(Integer iD, String name, Building building) {
		super();
		ID = iD;
		this.name = name;
		this.building = building;
	}
	public ClassRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ClassRoom [ID=" + ID + ", name=" + name + ", building=" + building + "]";
	}
	
	
	
}
