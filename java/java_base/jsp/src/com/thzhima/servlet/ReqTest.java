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
		 *  与请求有关的数据（Http协议、方法、path、请求头、数据、TCP/IP有关信息），
		 *  方法（请求转发，共享数据）都在请求对象中。
		*/
		
		String protocol = request.getProtocol();// 协议
		System.out.println("protocol:"+protocol);
		
		String method = request.getMethod(); // 方法
		System.out.println("method:"+method);
		
		String ctype = request.getHeader("User-Agent");// 取指定的头信息
		System.out.println("User-Agent:"+ ctype);
		
		Enumeration<String> headers = request.getHeaderNames();// 获取所有的请求头
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			String value = request.getHeader(header);
			System.out.format("%s:%s\n", header, value);
		}
		
		String name = request.getParameter("name");// 取请求发送的参数。
		System.out.println("name:"+ name);
		
		String[] hobbies = request.getParameterValues("hobby"); // 取有多个值的参数
		System.out.println("hobbies: "+Arrays.toString(hobbies));
		
		Map<String,String[]> params = request.getParameterMap();
		Set<Entry<String,String[]>> set = params.entrySet();
		for(Entry<String,String[]> e : set) {
			System.out.format("%s:%s\n", e.getKey(), Arrays.toString(e.getValue()));
		}
		
		Enumeration<String> paramNames = request.getParameterNames(); // 获取所有参数的名字
		
		//--------------------------------------------------
		String serverName = request.getServerName(); // 请求的服务器的名字
		int serverPort = request.getServerPort(); // 请求的服务器的端口号
		System.out.format("服务器->%s:%d \n", serverName, serverPort );
		
		String clientAddr = request.getRemoteAddr(); // 获取客户端的地址
		String clientHost = request.getRemoteHost(); // 远程（client）的主机名
		int clientPort = request.getRemotePort(); // 客户端的端口号。
		System.out.format("客户端：地址：%s, %s:%d\n", clientAddr, clientHost, clientPort);
		
		String uri = request.getRequestURI(); // uri path
		System.out.println("uri:"+uri);
		
		String query = request.getQueryString(); // Get方法？表示的请求参数
		System.out.println("Get参数：" +  query);
		
		String appPath = request.getContextPath(); // 取上下文路径
		System.out.println("contextPath: " + appPath);
		
		//====================================================
		request.setCharacterEncoding("utf-8"); // 设置字符编码
		request.setAttribute("msg", "今天是周4");  // 设置可以在一次请求中共享的数据
		request.setAttribute("msg2", "这周我们做项目");
		
		request.getRequestDispatcher("/req2").forward(request, response);// 请求转发
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
