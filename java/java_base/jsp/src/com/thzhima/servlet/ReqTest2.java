package com.thzhima.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/req2")
public class ReqTest2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("============================");
		Map<String,String[]> params = request.getParameterMap();
		Set<Entry<String,String[]>> set = params.entrySet();
		for(Entry<String,String[]> e : set) {
			System.out.format("%s:%s\n", e.getKey(), Arrays.toString(e.getValue()));
		}
		
		System.out.println(request.getAttribute("msg"));
		System.out.println(request.getAttribute("msg2"));
		
		System.out.println("--------------------------------");
		
//		request.setCharacterEncoding("utf-8");
		String loginName = request.getParameter("loginName");
		
		// ����������룬����ת�봦��
//		byte[] b = loginName.getBytes("iso-8859-1");
//		loginName = new String(b, "utf-8");
		
		System.out.println(loginName);
		
		//*******************��Ӧ**********************
		// ��http��Ӧͷ�й�����
//		response.setStatus(200);
//		response.setHeader("Location", "http://www.qq.com");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter(); // ��ȡ�������ֱ��������ݡ�
//		out.write("hello");
		
//		response.sendError(404);
		
		response.sendRedirect("http://www.sina.com.cn"); // �ض���
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
