package com.thzhima.advance.jdbc;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class StuDAO {

	public static User login(String userName, String pwd) throws SQLException {
		User  u = null;
		Map m = JdbcTemplate.find("select * from t_users where user_name=? and pwd=?", userName, pwd);
		if(m != null) {
			u = new User(((BigDecimal)m.get("USER_ID")).intValue(), (String)m.get("USER_NAME"), (String)m.get("PERSON_ID"),(String)m.get("PWD"));
		}
		return u;
	}
	
	public static User find(int id) throws SQLException {
		User u = null;
		
		String sql = "select * from t_users where user_id=?";
		
		ResultSetExtractor<User> ext = new ResultSetExtractor<User>() {

			@Override
			public User extract(ResultSet rst) throws SQLException {
				if(rst.next()) {
					int id = rst.getInt(1);
					String name = rst.getString(2);
					String persionID = rst.getString(3);
					String pwd = rst.getString(4);
					return new User(id, name,persionID, pwd);
				}
				return null;
			}
		};
		
		u = JdbcTemplate.find(sql, ext, id);
		
		return u;
	}
	
	public static void main(String[] args) throws SQLException {
//		System.out.println(login("Smith", "13579"));
		System.out.println(find(2));
	}
}
