package com.thzhima.jw.beans;
import com.thzhima.jw.beans.Class;

public class SubjectPlan {

	private Integer ID;
	private Class myClass;
	private ClassRoom classRoom;
	private Subject subject;
	private Integer week;
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	private Times times;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Class getMyClass() {
		return myClass;
	}
	public void setMyClass(Class myClass) {
		this.myClass = myClass;
	}
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Times getTimes() {
		return times;
	}
	public void setTimes(Times times) {
		this.times = times;
	}
	
	public SubjectPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubjectPlan(Integer iD, Class myClass, ClassRoom classRoom, Subject subject, Integer week, Times times) {
		super();
		ID = iD;
		this.myClass = myClass;
		this.classRoom = classRoom;
		this.subject = subject;
		this.week = week;
		this.times = times;
	}
	@Override
	public String toString() {
		return "SubjectPlan [ID=" + ID + ", myClass=" + myClass + ", classRoom=" + classRoom + ", subject=" + subject
				+ ", week=" + week + ", times=" + times + "]";
	}
	
	
	
	
}
