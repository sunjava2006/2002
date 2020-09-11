package com.thzhima.jw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.jw.beans.Student;
import com.thzhima.jw.dao.StudentDAO;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDao;
	
	public int addStudent(Student s) {
		return this.studentDao.add(s);
	}
}
