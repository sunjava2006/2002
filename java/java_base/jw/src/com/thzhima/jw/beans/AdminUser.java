package com.thzhima.jw.beans;

public class AdminUser {

	private int ID;
	private String loginName;
	private String pwd;
	
	public AdminUser(int iD, String loginName, String pwd) {
		super();
		ID = iD;
		this.loginName = loginName;
		this.pwd = pwd;
	}
	
	public AdminUser() {

	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "AdminUser [ID=" + ID + ", loginName=" + loginName + ", pwd=" + pwd + "]";
	}
	
	
	
}
