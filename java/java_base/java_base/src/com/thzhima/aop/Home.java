package com.thzhima.aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Home {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Human h = null;
		
		// 创建一个配置文件类型的对象。
		Properties p = new Properties();
		
		// 从类路径读文件，输入流
		InputStream in = Object.class.getResourceAsStream("/my.properties");
		p.load(in); // 加载输入流
		// 获取配置信息，获取实现类的类名。
		String className = p.getProperty("clean_man");
		
		// Java 反射方法、通过类型，创建一个表示该类的Class对象。（内省的机制）
	    Class clas = Class.forName(className);
	    h = (Human) clas.newInstance(); // 通过Class对象，创建该类的实例。
		
	    
		h.clean();
	}
}
