package com.thzhima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sess")
public class SessionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		// 获取Session自身信息
		System.out.println("session:"+ session.getId());
		System.out.println(session.getCreationTime());
		System.out.println(session.getLastAccessedTime());
		// 存储用户自己的数据
		session.setAttribute("key", "value"); // 在会话没有结束之前的信息
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
