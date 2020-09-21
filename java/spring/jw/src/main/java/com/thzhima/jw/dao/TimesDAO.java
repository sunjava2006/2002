package com.thzhima.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.jw.beans.Times;

@Mapper
public interface TimesDAO {

	@Select("select * from t_times")
	@Results(id = "TimesMapper",
	value= {
			@Result(property = "ID", column = "ID", id=true),
			@Result(property = "name", column = "name"),
			@Result(property = "startTime", column = "start_time"),
			@Result(property = "endTime", column = "end_time")
	})
	public List<Times> listAll();
	
	@Select("select * from t_times where id=#{id}")
	@ResultMap("TimesMapper")
	public Times findByID(int id);
	
	
}
