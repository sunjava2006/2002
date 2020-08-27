package com.thzhima.jw.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnUtil {

	static String user;
	static String pwd;
	static String url;
	static {
		Properties p = new Properties();
		InputStream in = ConnUtil.class.getResourceAsStream("/db.properties");
		try {
			p.load(in);
			
			String driverName = p.getProperty("driverName");
			Class.forName(driverName);
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
			url = p.getProperty("url");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, user, pwd);
	}
	
}
