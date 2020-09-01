package com.thzhima.jw.jdbc.dao;

import com.thzhima.jw.jdbc.JdbcTemplate;

public class StudentDAO {

	
	public static int delByClassID(int classID) throws Exception {
		String sql = "delete from t_students where class_id=?";
		return JdbcTemplate.saveOrUpdate(sql, classID);
	}
}
