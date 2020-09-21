package com.thzhima.jw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.jw.beans.Times;
import com.thzhima.jw.dao.TimesDAO;

@Service
public class TimesService {

	@Autowired
	private TimesDAO dao;
	
	public List<Times> listAll(){
		return this.dao.listAll();
	}
}
