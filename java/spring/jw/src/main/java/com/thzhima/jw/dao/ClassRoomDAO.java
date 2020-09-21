package com.thzhima.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import com.thzhima.jw.beans.ClassRoom;

@Mapper
public interface ClassRoomDAO {

	
	@Insert("insert into t_classrooms (id, name, building_id) values (#{ID},#{name},#{building.ID})")
	@SelectKey(before = true, keyProperty = "ID", keyColumn = "id", resultType = Integer.class,
	           statement = "select seq_classroom.nextval from dual")
	public int add(ClassRoom room);
	
	@SelectProvider(type = ClassRoomSQLProvider.class, method = "findByName")
	@Results(id = "ClassRoomMapper", 
	         value = {
	        		 @Result(property = "ID", column = "id", id=true),
	        		 @Result(property = "name", column = "name"),
	        		 @Result(property = "building", column = "building_id",
	        		         one = @One(select = "com.thzhima.jw.dao.BuildingDAO.findByID") )
	        		 })
	public List<ClassRoom> findByName(String name);
	
	
	@Delete("delete from t_classrooms where id=#{id}")
	@ResultType(Integer.class)
	public int delByID(int id);
	
	@Select("select * from t_classrooms")
	@ResultMap("ClassRoomMapper")
	public List<ClassRoom> listAll();
	
	
}
