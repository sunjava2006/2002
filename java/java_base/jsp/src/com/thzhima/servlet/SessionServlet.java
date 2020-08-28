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
		
		// ��ȡSession������Ϣ
		System.out.println("session:"+ session.getId());
		System.out.println(session.getCreationTime());
		System.out.println(session.getLastAccessedTime());
		// �洢�û��Լ�������
		session.setAttribute("key", "value"); // �ڻỰû�н���֮ǰ����Ϣ
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
