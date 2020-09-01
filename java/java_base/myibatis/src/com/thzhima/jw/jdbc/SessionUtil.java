package com.thzhima.jw.jdbc;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {

	private static SqlSessionFactory factory;
	
	static {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		try {
			Reader reader = Resources.getResourceAsReader("Configuration.xml");
			factory = builder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		return factory.openSession();
	}
	
}
