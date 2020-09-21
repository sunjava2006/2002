package com.thzhima.jw.dao;

import org.apache.ibatis.jdbc.SQL;

import com.thzhima.jw.beans.SubjectPlan;

public class SubjectPlanSqlProvider {

	public String findbyExam(SubjectPlan p) {
		SQL sql = new SQL();
		
		sql.SELECT("*").FROM("t_subject_plan");
		if(p.getID()!= null) {
			sql.WHERE("id=#{ID}");
		}else {
			if(p.getClassRoom()!=null) {
				sql.WHERE("class_room_id=#{classRoom.ID}");
			}
			if(p.getMyClass()!=null) {
				sql.WHERE("class_id=#{myClass.id}");
			}
			if(p.getSubject()!= null) {
				sql.WHERE("subject_id=#{subject.ID}");
			}
			if(p.getWeek()!=null) {
				sql.WHERE("week=#{week}");
			}
			if(p.getTimes()!=null) {
				sql.WHERE("times_id=#{times.ID}");
			}
		}
		
		return sql.toString();
	}
}
