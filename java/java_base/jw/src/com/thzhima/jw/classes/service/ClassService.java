package com.thzhima.jw.classes.service;

import java.util.List;

import com.thzhima.jw.jdbc.dao.ClassDAO;
import com.thzhima.jw.beans.Class;

public class ClassService {

	public static int addClass(String classNO, String className) throws Exception {
		return ClassDAO.insert(classNO, className);
	}
	
	public static List<com.thzhima.jw.beans.Class> queryClass(String classNO, String className, int page, int size) throws Exception {
		Class c = new Class(null, classNO, className, null);
		return ClassDAO.qualyFindByExample(c, page, size);
	}
	
	/**
	 * ��ѯ�ܼ�¼��
	 * @param classNO
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public static int totalRecord(String classNO, String className) throws Exception {
		Class c = new Class(null, classNO, className, null);
		return ClassDAO.qualyExampleCount(c);
	}
	
	/**
	 * �����ܵķ�ҳ��
	 * @param totalRecord
	 * @param size
	 * @return
	 */
	public static int totalPage(double totalRecord, double size) {
		return (int)Math.ceil(totalRecord/size);
	}
	
	/**
	 * ���ݰ༶ID,���°༶��Ϣ��
	 * @param classNO
	 * @param className
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static int updateByID(String classNO, String className, int id) throws Exception {
		return ClassDAO.updateByID(new Class(id,classNO, className, null));
	}
	
	public static void delClassWithStudents(int classID) throws Exception {
		ClassDAO.delByIDList(classID);
	}
}
