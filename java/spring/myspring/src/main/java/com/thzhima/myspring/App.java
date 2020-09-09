package com.thzhima.myspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thzhima.myspring.beans.Book;
import com.thzhima.myspring.beans.Home;

public class App 
{

	

    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("/app.xml");
        
        Book book = (Book) app.getBean("javaBook");
        System.out.println(book);
        Book book2 = (Book)app.getBean("javaPro");
        System.out.println(book2);
        
        
        Home h = app.getBean(Home.class);
        System.out.println(h);
//        XiaoHong xh = app.getBean(XiaoHong.class);
//        System.out.println( xh.getBookName());
        
//        XiaoLi xl = app.getBean(XiaoLi.class);
//        xl.doSth();
        
        
        
      
    }
}
