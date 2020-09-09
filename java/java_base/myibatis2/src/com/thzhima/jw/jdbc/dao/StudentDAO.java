package com.thzhima.jw.jdbc.dao;

import org.apache.ibatis.session.SqlSession;

import com.thzhima.jw.beans.Student;
import com.thzhima.jw.jdbc.SessionUtil;

public class StudentDAO implements StudentMapper{

	@Override
	public Student selectByID(int id) {
		Student c = null;
		SqlSession s = null;
		try {
			s = SessionUtil.getSession();
			StudentMapper impl = s.getMapper(StudentMapper.class);
			c = impl.selectByID(id);
			s.commit();
		} catch (Exception e) {
			s.rollback();
			throw e;
		} finally{
			if(null != s ) {
				s.close();
			}

		}
		return c;
	}

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		Student s = dao.selectByID(3);
		System.out.println(s);
		System.out.println(s.getMyClass());
	}
}
