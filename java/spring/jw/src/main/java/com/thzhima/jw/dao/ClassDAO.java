package com.thzhima.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

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
	        	@Result(property = "classNO", column = "class_no"),
	        	@Result(property = "students", column = "id", 
	        	        many = @Many(select = "com.thzhima.jw.dao.StudentDAO.queryByClassID"))
	         })
	public Class findByID(Integer id);
	
	@SelectProvider(type = ClassSqlProvider.class, method = "queryByExam")
	@ResultMap("ClassMapper")
	public List<Class> queryByExample(@Param("c")Class c,@Param("page") int page,@Param("size") int size);
	
	@SelectProvider(type=ClassSqlProvider.class, method="countByExam")
	@ResultType(Integer.class)
	public int countByExample(Class c);
	
	@Delete("delete from t_classes where id=#{id}")
	@ResultType(Integer.class)
	public int delByID(int id);
	
	@UpdateProvider(type = ClassSqlProvider.class, method = "updateByExam")
	@ResultType(Integer.class)
	public int updateByExample(Class c);
}
