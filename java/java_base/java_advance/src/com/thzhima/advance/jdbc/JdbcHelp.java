package com.thzhima.advance.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JdbcHelp {

	private static String url = "";
	private static String user = "";
	private static String password = "";
	
	static {
		try {
			Properties pro = new Properties();
			InputStream in = JdbcHelp.class.getResourceAsStream("/db.properties");
			pro.load(in);
			
			String driverName = pro.getProperty("driverName");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	
}
