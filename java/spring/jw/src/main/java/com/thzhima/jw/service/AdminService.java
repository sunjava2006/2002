package com.thzhima.jw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.dao.AdminDAO;

@Service
public class AdminService {

	@Autowired AdminDAO adminDAO;
	
	public AdminUser login(AdminUser u) {
		return this.adminDAO.findByExample(u);
	}
}
