package com.thzhima.jw.beans;

import java.io.Serializable;
import java.util.List;

public class Class implements Serializable{

	private Integer id;
	private String classNO;
	private String className;
	List<Student> students;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Class [id=" + id + ", classNO=" + classNO + ", className=" + className + ", students=" + students + "]";
	}
	public Class(Integer id, String classNO, String className, List<Student> students) {
		super();
		this.id = id;
		this.classNO = classNO;
		this.className = className;
		this.students = students;
	}
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
