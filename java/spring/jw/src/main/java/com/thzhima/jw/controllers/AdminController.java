package com.thzhima.jw.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
	public ModelAndView login(AdminUser us, HttpSession session, boolean autoLogin, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		String viewName = "manage";
		AdminUser u = this.adminService.login(us);
		if(u != null) {// login success
			mv.setViewName(viewName);
			session.setAttribute("userInfo", u);
			if(autoLogin) {
				Cookie c = new Cookie("loginName", u.getLoginName());
				Cookie c2 = new Cookie("pwd", u.getPwd());
				c.setMaxAge(10*24*60*60);
				c2.setMaxAge(10*24*60*60);
				res.addCookie(c);
				res.addCookie(c2);
				
			}
		}
		else {
			viewName = "index";
			mv.setViewName(viewName);
			mv.addObject("msg", "用户名或密码不正确。");
		}
	
		return mv;
	}
}
