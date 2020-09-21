package com.thzhima.jw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.jw.beans.Subject;
import com.thzhima.jw.dao.SubjectDAO;

@Service
public class SubjectService {

	@Autowired
	private SubjectDAO dao;
	
	public List<Subject> listAll(){
		return this.dao.listAll();
	}
}
