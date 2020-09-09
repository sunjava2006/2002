package com.thzhima.jw.jdbc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.thzhima.jw.beans.AdminUser;

public interface AdminMapper {

	@Select("select * from t_admins where login_name=#{loginName} and pwd=#{pwd}")
	@Results(id = "AdminUserMapper",
             value = {
            	@Result(property = "ID", column = "id", id = true),
            	@Result(property = "loginName", column = "login_name"),
            	@Result(property = "pwd", column = "pwd")
	         })
	public AdminUser find(AdminUser u);
	
	@Select("select * from t_admins where login_name=#{loginName} and pwd=#{pwd}")
	@ResultMap("AdminUserMapper")
	public AdminUser find2(@Param("loginName")String loginName, @Param("pwd")String pwd);
	
	@Update("update t_admins set pwd=#{pwd} where id=#{ID}")
	public int update(AdminUser u);
	
	@SelectKey(before = true, keyProperty = "ID", keyColumn = "id",
			  statement = "select seq_admin_id.nextval from dual", resultType = Integer.class)
	@Insert("insert into t_admins(id, login_name, pwd) values (#{ID}, #{loginName}, #{pwd})")
	public int insert(AdminUser u);
	
	@UpdateProvider(type = AdminProvider.class, method = "updateByExam")
	public int updateByExample(AdminUser u);
}
