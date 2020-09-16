package com.thzhima.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.thzhima.jw.beans.Building;

@Mapper
public interface BuildingDAO {

	@SelectKey(before = true, keyColumn = "id", keyProperty = "ID", 
			   resultType = Integer.class, statement = "select seq_building.nextval from dual")
	@Insert("insert into t_buildings(id, name, longitude, latitude) values (#{ID}, #{name}, #{longitude}, #{latitude})")
	public int insert(Building b);
	

	@SelectProvider(type = BuildingSqlProvider.class, method = "listByPage")
	@Results(id="BuildingMapper", 
	         value = {@Result(property = "ID", column = "id", id=true),
	        		 @Result(property = "name", column = "name"),
	        		 @Result(property = "longitude", column = "longitude"),
	        		 @Result(property = "latitude", column = "latitude")})
	public List<Building> listByPage(@Param("name")String name,@Param("page") int page,@Param("size") int size);
	
	@SelectProvider(type = BuildingSqlProvider.class, method = "countSql")
	@ResultType(Integer.class)
	public int count(String name);
	
	@Delete("delete from t_buildings where id=#{id}")
	@ResultType(Integer.class)
	public int delByID(int id);
	
	@UpdateProvider(type = BuildingSqlProvider.class, method = "update")
	@ResultType(Integer.class)
	public int updateByExample(Building b);
	
}
