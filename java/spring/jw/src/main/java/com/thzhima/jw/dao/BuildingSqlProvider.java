package com.thzhima.jw.dao;

import org.apache.ibatis.jdbc.SQL;

import com.thzhima.jw.beans.Building;

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
	
	public String update(Building b) {
		SQL sql = new SQL();
		
		sql.UPDATE("t_buildings");
		if(b.getName()!= null && !"".equals(b.getName().trim())) {
			sql.SET("name=#{name}");
		}
		if(b.getLongitude()!= null ) {
			sql.SET("longitude=#{longitude}");
		}
		if(b.getLatitude()!= null) {
			sql.SET("latitude=#{latitude}");
		}
		if(b.getID()!=null) {
			sql.WHERE("id=#{ID}");
		}
		else {
			sql.WHERE("1=2");
		}
		
		return sql.toString();
	}
}
