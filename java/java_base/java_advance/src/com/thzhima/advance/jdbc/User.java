package com.thzhima.advance.jdbc;


// Java Bean
public class User {

	private int userID;
	private String name;
	private String personID;
	private String pwd;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public User(int userID, String name, String personID, String pwd) {
		super();
		this.userID = userID;
		this.name = name;
		this.personID = personID;
		this.pwd = pwd;
	}

	public User(int userID, String name, String personID) {
		super();
		this.userID = userID;
		this.name = name;
		this.personID = personID;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", personID=" + personID + ", pwd=" + pwd + "]";
	}

	

}
