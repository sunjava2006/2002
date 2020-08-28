package com.thzhima.jw.classes.service;

import java.util.List;

import com.thzhima.jw.jdbc.dao.ClassDAO;

public class ClassService {

	public static int addClass(String classNO, String className) throws Exception {
		return ClassDAO.insert(classNO, className);
	}
	
	public static List<com.thzhima.jw.beans.Class> queryClass(String classNO, String className, int page, int size) throws Exception {
		return ClassDAO.queryByKey(classNO, className, page, size);
	}
	
	/**
	 * 查询总记录数
	 * @param classNO
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public static int totalRecord(String classNO, String className) throws Exception {
		return ClassDAO.queryByKeyCount(classNO, className);
	}
	
	/**
	 * 计算总的分页数
	 * @param totalRecord
	 * @param size
	 * @return
	 */
	public static int totalPage(double totalRecord, double size) {
		return (int)Math.ceil(totalRecord/size);
	}
}
