package com.thzhima.jw.jdbc.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thzhima.jw.beans.Class;
import com.thzhima.jw.jdbc.MybatisTemplate;

public class ClassDAO {
	private static final String CLASS_NAME = Class.class.getName();
	
	public static int insert(String classNO, String className) {
		return MybatisTemplate.insert(CLASS_NAME+".insert", new Class(null,classNO, className, null));
	}
	
	public static Class findByID(int id) {
		return MybatisTemplate.findOne(CLASS_NAME+".selectByID", id);
	}
	
	public static Class findByIDWithStudent(int id) {
		return MybatisTemplate.findOne(CLASS_NAME+".selectByIDWithStudent", id);
	}
	
	public static List<Class> qualyFindByExample(Class example, int page ,int size) {
		Map<String,Object> map = new HashMap<>();
		map.put("class", example);
		map.put("from", (page-1)*size);
		map.put("to", page*size);
		return MybatisTemplate.findList(CLASS_NAME+".qualyQueryNoOrName", map);
	}
	
	public static int qualyExampleCount(Class example) {
		
		return MybatisTemplate.findOne(CLASS_NAME+".count", example);
	}
	
	public static List<Class> findByExample(Class example) {
		return MybatisTemplate.findList(CLASS_NAME+".queryNoOrName", example);
	}
	
	public static int delByIDList(int... idlist) {
		return MybatisTemplate.delete(CLASS_NAME+".delByIDList", idlist);
	}
	
	public static int updateByID(Class example) {
		return MybatisTemplate.update(CLASS_NAME+".update", example);
	}
	
	
	public static void main(String[] args) {
//		Class c = findByIDWithStudent(1);
//		System.out.println(c);
		Class c = new Class(null, "15%", "%¼ÆËã»ú%", null);
		System.out.println(qualyFindByExample(c,1,1));
		System.out.println(qualyExampleCount(c));
	
//		System.out.println(delByIDList(100,200,300));
	}
}

