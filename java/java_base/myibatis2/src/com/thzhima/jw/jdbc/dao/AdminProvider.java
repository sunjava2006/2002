package com.thzhima.jw.jdbc.dao;

import org.apache.ibatis.jdbc.SQL;

import com.thzhima.jw.beans.AdminUser;

public class AdminProvider {

	public String updateByExam(AdminUser u) {
		String sqlStm = null;
		SQL sql = new SQL();
		sql.UPDATE("t_admins");
		if(u.getLoginName()!=null) {
			sql.SET("login_name=#{loginName}");
		}
		if(u.getPwd()!=null) {
			sql.SET("pwd=#{pwd}");
		}
		if(u.getID()!=null) {
			sql.WHERE("id=#{ID}");
		}
		else {
			sql.WHERE("1=2");
		}
		
		sqlStm = sql.toString();
		System.out.println("========================:"+sqlStm);
		return sqlStm;
	}
}
