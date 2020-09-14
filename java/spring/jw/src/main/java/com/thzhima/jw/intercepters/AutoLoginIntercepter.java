package com.thzhima.jw.intercepters;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.service.AdminService;

@Component
public class AutoLoginIntercepter implements HandlerInterceptor{

	@Autowired
	private AdminService as;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("------------------=====================");
		HttpSession session = request.getSession(true);
		
		Object o  = session.getAttribute("userInfo");
		if(o==null) {
			System.out.println("------------------now login now.");
			Cookie[] cks = request.getCookies();
			String loginName = null;
			String pwd = null;
			if(cks != null) {
				for(Cookie c : cks) {
					String name = c.getName();
					String val = c.getValue();
					if("loginName".equals(name)) {
						loginName = val;
					}else if("pwd".equals(name)) {
						pwd = val;
					}
				}
				if(loginName != null && pwd != null) {
					System.out.println("满足自动登录条件");
					AdminUser u  = as.login(new AdminUser(null, loginName, pwd));
					session.setAttribute("userInfo", u);
					response.sendRedirect("/manage.html");
				}
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
