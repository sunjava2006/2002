package com.thzhima.jw.jdbc.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.thzhima.jw.beans.Class;

public interface ClassMapper {

	@Select("select * from t_classes where id=#{id}")
	@Results(id="ClassMapper",
	         value= {
	        	@Result(property = "id", column = "id"),
	        	@Result(property = "className", column = "class_Name"),
	        	@Result(property = "classNO", column = "class_no")	
	         })
	public Class findByID(Integer id);
}
