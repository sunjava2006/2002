package com.thzhima.jw.classes.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzhima.jw.classes.service.ClassService;

@WebServlet("/addClass")
public class AddClassServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
		String classNO = req.getParameter("classNO");
		String className = req.getParameter("className");
		
		System.out.println(classNO+className);
		int count = 0;
		String msg = "添加班级成功";
		try {
			count = ClassService.addClass(classNO, className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count != 1) {
			msg = "添加班级失败";
		}
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/class.jsp").forward(req, resp);
	}

}
