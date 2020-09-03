package com.thzhima.jw.jdbc.dao;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.thzhima.jw.beans.Class;
import com.thzhima.jw.jdbc.MybatisTemplate;

public class ClassDAO {
	private static final String CLASS_NAME = Class.class.getName();
	public static Class findByID(int id) {
		return MybatisTemplate.findOne(CLASS_NAME+".selectByID", id);
	}
	
	public static Class findByIDWithStudent(int id) {
		return MybatisTemplate.findOne(CLASS_NAME+".selectByIDWithStudent", id);
	}
	
	public static List<Class> qualyFindByExample(Class example) {
		return MybatisTemplate.findList(CLASS_NAME+".qualyQueryNoOrName", example);
	}
	
	public static List<Class> findByExample(Class example) {
		return MybatisTemplate.findList(CLASS_NAME+".queryNoOrName", example);
	}
	
	public static int delByIDList(int... idlist) {
		return MybatisTemplate.delete(CLASS_NAME+".delByIDList", idlist);
	}
	
	
	public static void main(String[] args) {
//		Class c = findByIDWithStudent(1);
//		System.out.println(c);
		
//		System.out.println(findByExample(new Class(null, null, "¼ÆËã»ú", null)));
		
	
		System.out.println(delByIDList(100,200,300));
	}
}

