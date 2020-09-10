package com.thzhima.jw.dao;

import org.apache.ibatis.jdbc.SQL;

import com.thzhima.jw.beans.Class;

public class ClassSqlProvider {

	public String queryByExam(Class c, int page, int size) {
		SQL s = new SQL();
		SQL sql = new SQL();
		
		sql.SELECT("a.*, rownum ro").FROM("t_classes a");
		if(c.getId()!=null) {
			sql.WHERE("id=#{id}");
		}else {
			
			if(c.getClassNO()!=null && !"".equals(c.getClassNO().trim())) {
				sql.WHERE("class_no like #{classNO}");
			}
			sql.OR();
			if(c.getClassName()!=null && !"".equals(c.getClassName().trim())) {
				
				sql.WHERE("class_name like #{className}");
			}
			sql.AND();
			sql.WHERE("rownum <=$(page*size)");   // 注意参数用${}不是#{}。${}是到表达式的值,不是属性值。
			
		}
		
		s.SELECT("*").FROM("("+sql.toString()+")").WHERE("ro>${(page-1)*size}");
		
		return s.toString();
	}
}
