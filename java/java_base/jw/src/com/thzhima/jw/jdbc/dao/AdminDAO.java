package com.thzhima.jw.jdbc.dao;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.jdbc.JdbcTemplate;
import com.thzhima.jw.jdbc.ResultSetExtractor;

public class AdminDAO {

	public static AdminUser find(String loginName, String pwd) throws Exception {
		AdminUser u = null;
		ResultSetExtractor<AdminUser> ext = (rst)->{
			AdminUser ur = null;
			if(rst.next()) {
				int id = rst.getInt("id");
				String loginName2 = rst.getString("login_name");
				String pass = rst.getString("pwd");
				ur = new AdminUser(id, loginName2, pass);
			}
			return ur;
		};
		String sql = "select * from t_admins where login_name=? and pwd=?";
		u = JdbcTemplate.select(sql, ext, loginName, pwd);
		return u;
	}
}
