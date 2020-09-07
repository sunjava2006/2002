package com.thzhima.jw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/login")
	public String login(String loginName, String pwd) {
		System.out.println(loginName);
		System.out.println(pwd);
		AdminUser u = this.adminService.login(loginName, pwd);
		System.out.println(u);
		return("index");
	}
}
