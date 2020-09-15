package com.thzhima.jw.dao;

import org.apache.ibatis.jdbc.SQL;

public class BuildingSqlProvider {

	public String listByPage(String name, int page, int size) {
		SQL s = new SQL();
		SQL sql = new SQL();
		sql.SELECT("a.*, rownum ro ").FROM("t_buildings a");
		if(name != null && !"".equals(name)) {
			sql.WHERE("name like '%"+name+"%'");
		}
		sql.WHERE("rownum <= ${page*size}");
		s.SELECT("*").FROM("("+sql.toString()+")").WHERE("ro > ${(page-1)*size}");
		
		return s.toString();
	}
	
	public String countSql(String name) {
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("t_buildings");
		if(name != null && !"".equals(name)) {
			sql.WHERE("name like '%"+name+"%'");
		}
		return sql.toString();
	}
}
