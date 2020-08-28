package com.thzhima.jw.login.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(true).invalidate();//»√Session ß–ß
		
		Cookie c = new Cookie("loginName", "");
		Cookie c2 = new Cookie("pwd", "");
		c.setMaxAge(0);
		c2.setMaxAge(0);
		response.addCookie(c);
		response.addCookie(c2);
		
		response.sendRedirect("/");
		
	}

}
