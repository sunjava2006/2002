package com.thzhima.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.thzhima.jw.beans.Student;

@Mapper
public interface StudentDAO {

	@Select("select * from t_students where class_id=#{classId}")
	@Results(id = "StudentMapper",
    value = {
    	@Result(property = "ID", column = "id" ,id=true),
    	@Result(property = "stuNO", column = "stu_no"),
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
	
	@Delete("delete from t_students where class_id=#{classid}")
	@ResultType(Integer.class)
	public int delByClassID(int classid);
	
//	@SelectKey(before = true, keyProperty = "ID", keyColumn = "id",
//			resultType = Integer.class, statement = "select seq_student.nextval from dual")
	@SelectKey(before=true, keyProperty="myClass.id", keyColumn = "class_id",
	           resultType = Integer.class,statement = "select id from t_classes where class_no=#{myClass.classNO}")
	@Insert("insert into t_students(id, stu_no, name, gender,person_id, home_town, phone, photo, class_id) "
			+ "values(seq_student.nextval, #{stuNO}, #{name}, #{gender}, #{personID}, #{homeTown}, #{phone}, #{photo}, #{myClass.id}     )")
	public int add(Student s);
}
