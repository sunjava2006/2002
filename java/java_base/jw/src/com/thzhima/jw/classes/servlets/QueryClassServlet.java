package com.thzhima.jw.classes.servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzhima.jw.beans.Class;
import com.thzhima.jw.classes.service.ClassService;


@WebServlet("/queryClass")
public class QueryClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int size = 3;
	
   
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext application = config.getServletContext();
		String sizeStr = application.getInitParameter("page_size");
		size = Integer.parseInt(sizeStr);

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    request.getServletContext();
//	    this.getServletContext();
//	    request.getSession().getServletContext();
	    
	    
		System.out.println(request.getQueryString());
	    System.out.println(URLEncoder.encode("%"));
		String classNO = request.getParameter("classNO").trim();
		String className = request.getParameter("className").trim();
		String currPage = request.getParameter("currPage");
		int curr = currPage==null?1:Integer.parseInt(currPage);
		
		classNO = "".equals(classNO)?null: classNO;
		className = "".equals(className)?null: className;
		List<Class> list = null;
		int totalRecord = 0;
		int totalPage = 0;
		try {
			list = ClassService.queryClass(classNO, className, curr, size);
			totalRecord = ClassService.totalRecord(classNO, className);
			totalPage = ClassService.totalPage(totalRecord, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", curr);
		
		request.getRequestDispatcher("/class.jsp").forward(request, response);
	
	}

}
