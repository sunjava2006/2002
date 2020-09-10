package com.thzhima.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.jw.beans.Student;

@Mapper
public interface StudentDAO {

	@Select("select * from t_students where class_id=#{classId}")
	@Results(id = "StudentMapper",
    value = {
    	@Result(property = "ID", column = "id" ,id=true),
    	@Result(property = "stuID", column = "stu_id"),
    	@Result(property = "name", column = "name"),
    	@Result(property = "gender", column = "gender"),
    	@Result(property = "personID", column = "person_id"),
    	@Result(property = "homeTown", column = "home_town"),
    	@Result(property = "phone", column = "phone"),
    	@Result(property = "photo", column = "photo"),
    	@Result(property = "myClass", column = "class_id",
    	        one = @One(select = "com.thzhima.jw.dao.ClassDAO.findByID"))
    })
	public List<Student> queryByClassID(int classId);
}
