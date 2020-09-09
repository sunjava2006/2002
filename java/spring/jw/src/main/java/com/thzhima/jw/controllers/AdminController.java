package com.thzhima.jw.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/login.do")
	public ModelAndView login(AdminUser us, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String viewName = "manage";
		AdminUser u = this.adminService.login(us);
		if(u != null) {// login success
			mv.setViewName(viewName);
			session.setAttribute("userInfo", u);
		}
		else {
			viewName = "index";
			mv.setViewName(viewName);
			mv.addObject("msg", "用户名或密码不正确。");
		}
	
		return mv;
	}
}
