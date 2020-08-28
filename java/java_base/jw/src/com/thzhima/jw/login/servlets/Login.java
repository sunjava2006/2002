package com.thzhima.jw.login.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.login.service.AdminService;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String p = this.getServletContext().getRealPath("/");
		System.out.println(p);
		
		String loginName = request.getParameter("loginName");
		String pwd = request.getParameter("pwd");
		AdminUser user = null;

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		try {
			user = AdminService.adminLogin(loginName, pwd);
		} catch (Exception e) {
			e.printStackTrace();
			// ��ȡ����ת������
			request.setAttribute("msg", "��¼�����쳣��");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);// ת��
		}
		if (null != user) {
			String auto = request.getParameter("autoLogin");
			if(null != auto) {
				Cookie c = new Cookie("loginName", user.getLoginName());
				Cookie c2 = new Cookie("pwd", user.getPwd());
				c.setMaxAge(60*60*24*10);
				c2.setMaxAge(60*60*24*10);
				response.addCookie(c);
				response.addCookie(c2);
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("userInfo", user);
			response.sendRedirect("/manage.html"); // �ض���
		} else {
			// ��ȡ����ת������
			request.setAttribute("msg", "�û��������벻��ȷ��");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);// ת��
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
