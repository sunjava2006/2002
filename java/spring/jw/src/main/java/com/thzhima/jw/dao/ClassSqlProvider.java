package com.thzhima.jw.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.thzhima.jw.beans.Class;

public class ClassSqlProvider {

	public String queryByExam(@Param("c")Class c,@Param("page") int page,@Param("size") int size) {
		SQL s = new SQL();
		SQL sql = new SQL();
		
		sql.SELECT("a.*, rownum ro").FROM("t_classes a");
		if(c.getId()!=null) {
			sql.WHERE("id=#{c.id}");
		}else {
			
			if(c.getClassNO()!=null && !"".equals(c.getClassNO().trim())) {
				sql.WHERE("class_no like #{c.classNO}");
			}
			
			if(c.getClassName()!=null && !"".equals(c.getClassName().trim())) {
				sql.OR();
				sql.WHERE("class_name like #{c.className}");
			}
			sql.AND();
			sql.WHERE("rownum <=${page*size}");   // 注意参数用${}不是#{}。${}是到表达式的值,不是属性值。
			
		}
		
		s.SELECT("*").FROM("("+sql.toString()+")").WHERE("ro>${(page-1)*size}");
		
		return s.toString();
	}
	
	public String countByExam(Class c) {
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("t_classes");
		if(c.getId()!=null) {
			sql.WHERE("id=#{id}");
		}else {
			
			if(c.getClassNO()!=null && !"".equals(c.getClassNO().trim())) {
				sql.WHERE("class_no like #{classNO}");
			}
			
			if(c.getClassName()!=null && !"".equals(c.getClassName().trim())) {
				sql.OR();
				sql.WHERE("class_name like #{className}");
			}

		}
		return sql.toString();
	}
	
	public String updateByExam(Class c) {
		SQL sql = new SQL();
		
		sql.UPDATE("t_classes");
		if(c.getClassNO()!=null) {
			sql.SET("class_no=#{classNO}");
		}
		if(c.getClassName()!= null) {
			sql.SET("class_name=#{className}");
		}
		if(c.getId()!= null) {
			sql.WHERE("id=#{id}");
		}
		else {
			sql.WHERE("1=2");
		}
		
		return sql.toString();
	}
}
