package com.thzhima.jw.classes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzhima.jw.classes.service.ClassService;


@WebServlet("/delClass")
public class DelClassServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int classID = Integer.parseInt(id);
		try {
			ClassService.delClassWithStudents(classID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String previousURL = request.getHeader("Referer");// 获取之间页面的URL.
		response.sendRedirect(previousURL);// 让浏览器再查询一次之前的页面。
	}

}
