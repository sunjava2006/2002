package com.thzhima.jw.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.thzhima.jw.beans.ClassRoom;

@Mapper
public interface ClassRoomDAO {

	
	@Insert("insert into t_classrooms (id, name, building_id) values (#{ID},#{name},#{building.ID})")
	@SelectKey(before = true, keyProperty = "ID", keyColumn = "id", resultType = Integer.class,
	           statement = "select seq_classroom.nextval from dual")
	public int add(ClassRoom room);
	
}
