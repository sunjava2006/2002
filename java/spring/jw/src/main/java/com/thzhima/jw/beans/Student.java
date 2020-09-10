package com.thzhima.jw.beans;

import java.io.Serializable;

public class Student implements Serializable{
	
	private Integer ID;
	private String stuNO;
	private String name;
	private String gender;
	private String personID;
	private String homeTown;
	private String phone;
	private Class myClass; 
	private String photo;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getStuNO() {
		return stuNO;
	}
	public void setStuNO(String stuNO) {
		this.stuNO = stuNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Class getMyClass() {
		return myClass;
	}
	public void setMyClass(Class myClass) {
		this.myClass = myClass;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Student(Integer iD, String stuNO, String name, String gender, String personID, String homeTown, String phone,
			Class myClass, String photo) {
		super();
		ID = iD;
		this.stuNO = stuNO;
		this.name = name;
		this.gender = gender;
		this.personID = personID;
		this.homeTown = homeTown;
		this.phone = phone;
		this.myClass = myClass;
		this.photo = photo;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", stuNO=" + stuNO + ", name=" + name + ", gender=" + gender + ", personID="
				+ personID + ", homeTown=" + homeTown + ", phone=" + phone + ", myClass=不输出"  + ", photo=" + photo
				+ "]";
	}
	
	
	
	
}
