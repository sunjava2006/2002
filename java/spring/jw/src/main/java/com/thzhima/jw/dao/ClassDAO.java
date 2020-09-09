package com.thzhima.jw.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.thzhima.jw.beans.Class;

@Mapper
public interface ClassDAO {

	@SelectKey(before = true, keyColumn = "id", keyProperty = "id", 
			statement = "select seq_class.nextval from dual", resultType = Integer.class)
	@Insert("insert into t_classes (id, class_no, class_name) values (#{id}, #{classNO},  #{className})")
	public int insert(Class c);
	
	@Select("select * from t_classes where id=#{id}")
	@Results(id="ClassMapper",
	         value= {
	        	@Result(property = "id", column = "id"),
	        	@Result(property = "className", column = "class_Name"),
	        	@Result(property = "classNO", column = "class_no")	
	         })
	public Class findByID(Integer id);
}
