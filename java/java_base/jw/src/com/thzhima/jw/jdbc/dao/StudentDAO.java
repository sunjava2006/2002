package com.thzhima.jw.jdbc.dao;

import com.thzhima.jw.beans.Student;
import com.thzhima.jw.jdbc.MybatisTemplate;

public class StudentDAO {

	private static final String STUDENDT_CLASS_NAME = Student.class.getName();
	
	public static int insert(Student s) {
		return MybatisTemplate.insert(STUDENDT_CLASS_NAME+".insert", s);
	}
	
	public static Student findByID(int id) {
		return MybatisTemplate.findOne(STUDENDT_CLASS_NAME+".selectByID2", id);
	}
	
	public static void main(String[] args) {
//		com.thzhima.jw.beans.Class c = ClassDAO.findByID(1);
//		Student s = new Student(null, "15010201", "ÕÔÃ÷", "ÄÐ", "3201111111", "ÄÏ¾©", "12345678", c, null);
//		System.out.println(insert(s));
		
		System.out.println(findByID(3));
	}
}
