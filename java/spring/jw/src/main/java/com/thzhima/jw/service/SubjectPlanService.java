package com.thzhima.jw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.jw.beans.SubjectPlan;
import com.thzhima.jw.dao.SubjectPlanDAO;

@Service
public class SubjectPlanService {

	@Autowired
	private SubjectPlanDAO dao;
	
	public int add(SubjectPlan sp) {
		return dao.add(sp);
	}
}
