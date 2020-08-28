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
		if(null == o) {// û��¼
			String path = req.getRequestURI();
			if(path.startsWith("/js/") || "/favicon.ico".equals(path) || "/login".equals(path)) {// ������Ǿ�̬��Դ���¼ҳ�棬ֱ�ӷ���
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
				// �ж��Ƿ������¼����
				if(loginName!=null && pwd!=null) {
					AdminUser u = null;
					try {
						u = AdminService.adminLogin(loginName, pwd);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(u!=null) {//��¼�ɹ����û���Ϣ����session ���ض��򵽹���ҳ�档
						session.setAttribute("userInfo", u);
						((HttpServletResponse)response).sendRedirect("/manage.html");
					}
					else { // ��¼ʧ��
						req.getRequestDispatcher("/index.jsp").forward(request, response);
						chain.doFilter(request, response);
						return;
					}
				}
				else { // �������¼����
					if("/".equals(path)) {
						chain.doFilter(request, response);
						return;
					}else {// û��¼������£����ʵĲ��ǵ�¼ҳ�棬�ǲ�����ġ�ת����¼ҳ�档
						req.getRequestDispatcher("/index.jsp").forward(request, response);
						chain.doFilter(request, response);
						return;
					}
				}
			}else {// û��Cookies
				if("/".equals(path)) {
					chain.doFilter(request, response);
					return;
				}else {// û��¼������£����ʵĲ��ǵ�¼ҳ�棬�ǲ�����ġ�ת����¼ҳ�档
					req.getRequestDispatcher("/index.jsp").forward(request, response);
					chain.doFilter(request, response);
					return;
				}
				
			}

		}
		else {// �Ѿ���¼
			// ������Ѿ���¼������£����ʵ�¼ҳ�潻��ת��������ҳ�档
			String path = req.getRequestURI();
			if("".equals(path) || "/".equals(path)) {
				req.getRequestDispatcher("/manage.html").forward(request, response);
				chain.doFilter(request, response);
				return;
			}else {//�Ѿ���¼ �����ʵĲ��ǵ�¼ҳ�档�����Է��ʡ�
				chain.doFilter(request, response);
			}
			
		}
		
	}

	
	

}
