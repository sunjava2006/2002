package com.thzhima.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.jw.beans.Subject;

@Mapper
public interface SubjectDAO {

	@Select("select * from t_subjects")
	@Results(id = "SubjectMapper",
	         value = {
	        		 @Result(property = "ID", column = "ID", id = true),
	        		 @Result(property = "name", column = "name")
	         })
	public List<Subject> listAll();
	
	
	
	@Select("select * from t_subjects where id=#{id}")
	@ResultMap("SubjectMapper")
	public Subject findByID(int id);
}
