package com.thzhima.jw.listeners;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitDataListener implements ServletContextListener , ServletContextAttributeListener{

	public void contextInitialized(ServletContextEvent evt)  { 
        ServletContext application = evt.getServletContext();
        // 初始化一个当前在线管理员人名列表
        application.setAttribute("adminList", new ArrayList<String>());
        
        // 取访问计数
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
	
	
	private void write(ServletContext application) {
        FileWriter writer = null;
        
        try {
        	String path = application.getRealPath("/");
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
	
    public void contextDestroyed(ServletContextEvent evt)  { 
    	ServletContext application = evt.getServletContext();
        this.write(application);
        
    }

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		ServletContextAttributeListener.super.attributeAdded(event);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		ServletContextAttributeListener.super.attributeRemoved(event);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		String attName = event.getName();
		if("accessCount".equals(attName)) {
			int count = (Integer)event.getValue();
			if(count%10000==0) {
				this.write(event.getServletContext());
			}
		}
	}

    
    
}
