package com.thzhima.jw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.jw.dao.ClassDAO;
import com.thzhima.jw.beans.Class;

@Service
public class ClassService {

	@Autowired
	private ClassDAO classCao;
	
	public int addClass(Class c) {
		return this.classCao.insert(c);
	}
	
}
