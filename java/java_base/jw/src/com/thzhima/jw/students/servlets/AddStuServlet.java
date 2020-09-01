package com.thzhima.jw.students.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/addStu")
public class AddStuServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletContext().getRealPath("/photos");
		System.out.println(path);
		String n = req.getParameter("name");
		System.out.println("++++++++++++++"+ n);
		
//		Collection<Part>  parts = req.getParts();
//		for(Part p : parts) {
//			String name = p.getName();
//			if("photo".equals(name)) {
//				String fileName = p.getSubmittedFileName();
//				
//				System.out.println(name+":"+fileName);
//				p.write(path+"/"+fileName);
//				
//			}
//			
//		}
		// 取上传的文件
		Part p = req.getPart("photo");
		String name = p.getName();
		String fileName = p.getSubmittedFileName();
		String sufix = fileName.substring(fileName.lastIndexOf("."));
		fileName = System.currentTimeMillis()+sufix;
		System.out.println(name+":"+fileName);
		p.write(path+"/"+fileName); // 保存文件
		
	}

	
}
