package com.thzhima.jw.listeners;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitDataListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent evt)  { 
        ServletContext application = evt.getServletContext();
        String path = application.getRealPath("/"); // 获取应用根目录物理路径。
        FileReader reader = null;
        BufferedReader bufreader = null;
        try {
			reader = new FileReader(path+"/count.txt");
			bufreader = new BufferedReader(reader);
			String str = bufreader.readLine();
			int count = Integer.parseInt(str);
			application.setAttribute("accessCount", count);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != bufreader) {
					bufreader.close();
				}
				if(null != reader) {
					reader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
    }
	
    public void contextDestroyed(ServletContextEvent evt)  { 
    	ServletContext application = evt.getServletContext();
        String path = application.getRealPath("/");
        FileWriter writer = null;
        
        try {
			writer = new FileWriter(path+"/count.txt");
			
			int count = (Integer)application.getAttribute("accessCount");
			writer.write(String.valueOf(count));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(null != writer) {
					writer.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
    }

}
