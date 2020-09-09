package com.thzhima.jw.dao;

import org.apache.ibatis.jdbc.SQL;

import com.thzhima.jw.beans.AdminUser;

public class AdminSqlProvider {

	public String selectByExam(AdminUser u) {
		String s = null;
		SQL sql = new SQL();
		sql.SELECT("*").FROM("t_admins");
		if(u.getID()!=null) {
			sql.WHERE("id=#{ID}");
		}
		else {
			if(u.getLoginName()!=null && u.getPwd()!=null) {
				sql.WHERE("login_name=#{loginName} and pwd=#{pwd}");
			}
			else {
				sql.WHERE("1=2");
			}
		}
		s = sql.toString();
		return s;
	}
}
