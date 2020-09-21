package com.thzhima.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import com.thzhima.jw.beans.SubjectPlan;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface SubjectPlanDAO {

	@Insert("insert into t_subject_plan (id, class_id, class_room_id, subject_id, times_id, week) "
			+ "values (#{ID}, #{myClass.id}, #{classRoom.ID}, #{subject.ID}, #{times.ID}, #{week})")
	@SelectKey(before = true, keyColumn = "id", keyProperty = "ID", resultType = Integer.class, 
	           statement = "select seq_subject_plan.nextval from dual")
	public int add(SubjectPlan p);
	
	@SelectProvider(type = SubjectPlanSqlProvider.class, method = "findbyExam")
	@Results(id = "SubjectPlanMapper",
	         value = {
	        		 @Result(property = "ID", column = "id", id=true),
	        		 @Result(property = "myClass", column = "class_id", 
	        		         one = @One(select = "com.thzhima.jw.dao.ClassDAO.findByID2")),
	        		 @Result(property = "classRoom" , column = "class_room_id",
	        		         one = @One(select = "com.thzhima.jw.dao.ClassRoomDAO.findByID")),
	        		 @Result(property = "subject" , column = "subject_id",
	        		         one = @One(select = "com.thzhima.jw.dao.SubjectDAO.findByID")),
	        		 @Result(property = "times", column = "times_id", 
	        		         one = @One(select = "com.thzhima.jw.dao.TimesDAO.findByID"))
	         })
	public List<SubjectPlan> findByExam(SubjectPlan p);
	
	@Select("select * from t_subject_plan where week=#{week} and class_id=#{classID} and "+ 
			"times_id = (select id from t_times where start_time BETWEEN #{startTime} and #{endTime})")
	@ResultMap("SubjectPlanMapper")
	public SubjectPlan currentPlan(@Param("week")int week,@Param("startTime") double startTime,@Param("endTime") double endTime, @Param("classID") int classID);
}
