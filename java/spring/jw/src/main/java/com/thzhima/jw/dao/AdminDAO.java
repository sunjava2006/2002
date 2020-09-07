package com.thzhima.jw.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.jw.beans.AdminUser;

@Mapper
public interface AdminDAO {

	@Select(value = "select * from t_admins where login_name=#{loginName} and pwd=#{pwd}")
	@Results(id = "AdminUserMap", 
	value = {
		@Result(property = "ID", column = "id", id = true),
		@Result(property = "loginName", column = "login_name"),
		@Result(property = "pwd", column = "pwd")
	})
	public AdminUser findByLoginNamePwd(String loginName, String pwd);
}
