package com.thzhima.jw.dao;

import org.apache.ibatis.jdbc.SQL;

public class ClassRoomSQLProvider {

	public String findByName(String name) {
		SQL sql = new SQL();
		
		sql.SELECT("*").FROM("t_classrooms");
		if(name!=null) {
			sql.WHERE("name like '%"+name+"%'");
		}

		return sql.toString();
	}
}
