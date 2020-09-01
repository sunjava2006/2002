package com.thzhima.jw.listeners;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.thzhima.jw.beans.AdminUser;


@WebListener
public class AccessCountListener implements HttpSessionListener, HttpSessionAttributeListener {

  
    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession session = se.getSession();
         ServletContext application = session.getServletContext();
         int count = (Integer)application.getAttribute("accessCount");
         application.setAttribute("accessCount", count+1);
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
        HttpSession session = se.getSession();
        AdminUser user = (AdminUser)session.getAttribute("userInfo");
        if(user!=null) {
        	 String loginName = user.getLoginName();
             List<String> list = (List)session.getServletContext().getAttribute("adminList");
             list.remove(loginName);
             System.out.println("session destory:"+loginName);
        }
       
    }

	
    public void attributeAdded(HttpSessionBindingEvent se)  { 
        String attName = se.getName();
        if("userInfo".equals(attName)) {
        	AdminUser u = (AdminUser)se.getValue();
        	String loginName = u.getLoginName();
        	ServletContext application = se.getSession().getServletContext();
        	List<String> list = (List<String>)application.getAttribute("adminList");
        	// 判断当前用户是否重复登录
        	if(list.contains(loginName)) {
        		se.getSession().removeAttribute("userInfo");
        		
        	}
        	
        	
        	
        	// 添加新登录用户，到当前在线列表中
        	list.add(loginName);
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         String attName = se.getName();
         if("userInfo".equals(attName)){
        	 AdminUser u = (AdminUser)se.getValue();
        	 String name = u.getLoginName();
        	 
        	 List<String> list = (List<String>)se.getSession().getServletContext().getAttribute("adminList");
             list.remove(name);
         }
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
