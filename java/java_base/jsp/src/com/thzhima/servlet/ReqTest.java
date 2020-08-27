package com.thzhima.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/req")
public class ReqTest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  �������йص����ݣ�HttpЭ�顢������path������ͷ�����ݡ�TCP/IP�й���Ϣ����
		 *  ����������ת�����������ݣ�������������С�
		*/
		
		String protocol = request.getProtocol();// Э��
		System.out.println("protocol:"+protocol);
		
		String method = request.getMethod(); // ����
		System.out.println("method:"+method);
		
		String ctype = request.getHeader("User-Agent");// ȡָ����ͷ��Ϣ
		System.out.println("User-Agent:"+ ctype);
		
		Enumeration<String> headers = request.getHeaderNames();// ��ȡ���е�����ͷ
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			String value = request.getHeader(header);
			System.out.format("%s:%s\n", header, value);
		}
		
		String name = request.getParameter("name");// ȡ�����͵Ĳ�����
		System.out.println("name:"+ name);
		
		String[] hobbies = request.getParameterValues("hobby"); // ȡ�ж��ֵ�Ĳ���
		System.out.println("hobbies: "+Arrays.toString(hobbies));
		
		Map<String,String[]> params = request.getParameterMap();
		Set<Entry<String,String[]>> set = params.entrySet();
		for(Entry<String,String[]> e : set) {
			System.out.format("%s:%s\n", e.getKey(), Arrays.toString(e.getValue()));
		}
		
		Enumeration<String> paramNames = request.getParameterNames(); // ��ȡ���в���������
		
		//--------------------------------------------------
		String serverName = request.getServerName(); // ����ķ�����������
		int serverPort = request.getServerPort(); // ����ķ������Ķ˿ں�
		System.out.format("������->%s:%d \n", serverName, serverPort );
		
		String clientAddr = request.getRemoteAddr(); // ��ȡ�ͻ��˵ĵ�ַ
		String clientHost = request.getRemoteHost(); // Զ�̣�client����������
		int clientPort = request.getRemotePort(); // �ͻ��˵Ķ˿ںš�
		System.out.format("�ͻ��ˣ���ַ��%s, %s:%d\n", clientAddr, clientHost, clientPort);
		
		String uri = request.getRequestURI(); // uri path
		System.out.println("uri:"+uri);
		
		String query = request.getQueryString(); // Get��������ʾ���������
		System.out.println("Get������" +  query);
		
		String appPath = request.getContextPath(); // ȡ������·��
		System.out.println("contextPath: " + appPath);
		
		//====================================================
		request.setCharacterEncoding("utf-8"); // �����ַ�����
		request.setAttribute("msg", "��������4");  // ���ÿ�����һ�������й��������
		request.setAttribute("msg2", "������������Ŀ");
		
		request.getRequestDispatcher("/req2").forward(request, response);// ����ת��
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
