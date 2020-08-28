package com.thzhima.jw.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.login.service.AdminService;


@WebFilter("/*")
public class AutoLoginFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(true);
		Object o = session.getAttribute("userInfo");
		if(null == o) {// 没登录
			String path = req.getRequestURI();
			if(path.startsWith("/js/") || "/favicon.ico".equals(path) || "/login".equals(path)) {// 请求的是静态资源或登录页面，直接放行
				chain.doFilter(request, response);
				return;
			}
			
			Cookie[] cks = req.getCookies();
			if(cks!=null) {
				String loginName = null;
				String pwd = null;
				for(Cookie c : cks) {
					String name = c.getName();
					if("loginName".equals(name)) {
						loginName = c.getValue();
					}else if("pwd".equals(name)) {
						pwd = c.getValue();
					}
				}
				// 判断是否满足登录条件
				if(loginName!=null && pwd!=null) {
					AdminUser u = null;
					try {
						u = AdminService.adminLogin(loginName, pwd);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(u!=null) {//登录成功，用户信息加入session 。重定向到管理页面。
						session.setAttribute("userInfo", u);
						((HttpServletResponse)response).sendRedirect("/manage.html");
					}
					else { // 登录失败
						req.getRequestDispatcher("/index.jsp").forward(request, response);
						chain.doFilter(request, response);
						return;
					}
				}
				else { // 不满足登录条件
					if("/".equals(path)) {
						chain.doFilter(request, response);
						return;
					}else {// 没登录的情况下，访问的不是登录页面，是不允许的。转到登录页面。
						req.getRequestDispatcher("/index.jsp").forward(request, response);
						chain.doFilter(request, response);
						return;
					}
				}
			}else {// 没有Cookies
				if("/".equals(path)) {
					chain.doFilter(request, response);
					return;
				}else {// 没登录的情况下，访问的不是登录页面，是不允许的。转到登录页面。
					req.getRequestDispatcher("/index.jsp").forward(request, response);
					chain.doFilter(request, response);
					return;
				}
				
			}

		}
		else {// 已经登录
			// 如果在已经登录的情况下，访问登录页面交被转发到管理页面。
			String path = req.getRequestURI();
			if("".equals(path) || "/".equals(path)) {
				req.getRequestDispatcher("/manage.html").forward(request, response);
				chain.doFilter(request, response);
				return;
			}else {//已经登录 ，访问的不是登录页面。都可以访问。
				chain.doFilter(request, response);
			}
			
		}
		
	}

	
	

}
