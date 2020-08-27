package com.thzhima.jw.classes.service;

import com.thzhima.jw.jdbc.dao.ClassDAO;

public class ClassService {

	public static int addClass(String classNO, String className) throws Exception {
		return ClassDAO.insert(classNO, className);
	}
}
