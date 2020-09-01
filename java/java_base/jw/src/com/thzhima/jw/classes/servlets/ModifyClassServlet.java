package com.thzhima.jw.classes.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzhima.jw.classes.service.ClassService;

@WebServlet("/modifyClass")
public class ModifyClassServlet extends HttpServlet{

	String charset;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.charset = config.getServletContext().getInitParameter("charset");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String classNO = req.getParameter("classNO");
		String className = req.getParameter("className");
		int idd = Integer.parseInt(id);
		int count = 0;
		try {
			count = ClassService.updateByID(classNO, className, idd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count!=1) {
			
			resp.setCharacterEncoding(charset);
			resp.setContentType("text/html;charset="+charset);
			resp.getWriter().write("û�ܳɹ��޸�");
			
		}else {
			String previousURL = req.getHeader("Referer");// ��ȡ֮��ҳ���URL.
			resp.sendRedirect(previousURL);// ��������ٲ�ѯһ��֮ǰ��ҳ�档
		}
				
	}

}
