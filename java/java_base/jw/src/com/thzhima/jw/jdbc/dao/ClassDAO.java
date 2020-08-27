package com.thzhima.jw.jdbc.dao;

import com.thzhima.jw.jdbc.JdbcTemplate;

public class ClassDAO {

	public static int insert(String classNO, String className) throws Exception {
		int count = 0;
		String sql ="insert into t_classes values (seq_class.nextval, ?, ?)";
		count = JdbcTemplate.saveOrUpdate(sql, classNO, className);
		return count;
	}
}
