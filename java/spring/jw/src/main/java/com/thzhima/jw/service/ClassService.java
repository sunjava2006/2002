package com.thzhima.jw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.jw.beans.Class;
import com.thzhima.jw.dao.ClassDAO;

@Service
public class ClassService {

	@Autowired
	private ClassDAO classCao;
	
	public int addClass(Class c) {
		return this.classCao.insert(c);
	}
	
	public List<Class> query(Class c, int page, int size){
		return this.classCao.queryByExample(c, page, size);
	}
}
