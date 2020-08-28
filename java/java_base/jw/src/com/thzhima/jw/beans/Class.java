package com.thzhima.jw.beans;

public class Class {

	private int id;
	private String classNO;
	private String className;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassNO() {
		return classNO;
	}
	public void setClassNO(String classNO) {
		this.classNO = classNO;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Class(int id, String classNO, String className) {
		super();
		this.id = id;
		this.classNO = classNO;
		this.className = className;
	}
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Class [id=" + id + ", classNO=" + classNO + ", className=" + className + "]";
	}
	
	
}
