package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplate {
	
	public static <T> T find(String sql, ResultSetExtractor<T> extractor, Object...args) throws SQLException {
		T t = null;
		Map<String, Object> map = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		try {
			conn = JdbcHelp.getConn();
			stm = conn.prepareStatement(sql);
			if(args!=null) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			
			rst = stm.executeQuery();
			t = extractor.extract(rst);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return t;
	}
	
	public static Map<String, Object> find(String sql) throws SQLException{
		Map<String, Object> map = null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		try {
			conn = JdbcHelp.getConn();
			stm = conn.createStatement();
			
			rst = stm.executeQuery(sql);
			
			ResultSetMetaData md = rst.getMetaData(); // 获取元数据对象
			int colCount = md.getColumnCount();// 查询返回了几列
			if(rst.next()) {
				map = new HashMap<>();
				for(int i=1; i<=colCount; i++) {
					String name = md.getColumnName(i);
					String label = md.getColumnLabel(i);
					String className = md.getColumnClassName(i);
					String typeName = md.getColumnTypeName(i);
					
					Object value = rst.getObject(i);
					
					map.put(name, value);

				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		
		return map;
	}
	
	public static Map<String, Object> find(String sql, Object...args) throws SQLException{
		Map<String, Object> map = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		try {
			conn = JdbcHelp.getConn();
			stm = conn.prepareStatement(sql);
			if(args!=null) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			
			rst = stm.executeQuery();
			
			ResultSetMetaData md = rst.getMetaData(); // 获取元数据对象
			int colCount = md.getColumnCount();// 查询返回了几列
			if(rst.next()) {
				map = new HashMap<>();
				for(int i=1; i<=colCount; i++) {
					String name = md.getColumnName(i);
					String label = md.getColumnLabel(i);
					String className = md.getColumnClassName(i);
					String typeName = md.getColumnTypeName(i);
					
					Object value = rst.getObject(i);
					
					map.put(name, value);

				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		
		return map;
	}
	
    public static List<Map<String, Object>> list(String sql, Object...args) throws SQLException{
		List<Map<String, Object>> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		
		try {
			conn = JdbcHelp.getConn();
			stm = conn.prepareStatement(sql);
			if(args!=null) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			rst = stm.executeQuery();
			ResultSetMetaData md = rst.getMetaData();
			int colCount = md.getColumnCount();
			while(rst.next()) {
				// 每一条记录，都存储在一个map中。
				Map<String, Object> m = new HashMap<>();
				for(int i=1; i<=colCount; i++) {// 遍历每列
					String name = md.getColumnLabel(i); // 取每列的名字
					Object value = rst.getObject(i); // 取系列的值
					m.put(name, value);
				}
				list.add(m);// 将记录加入到list中。
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return list;
	}
    
    public static List<Map<String, Object>> list(String sql) throws SQLException{
		List<Map<String, Object>> list = new ArrayList<>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		
		try {
			conn = JdbcHelp.getConn();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql);
			ResultSetMetaData md = rst.getMetaData();
			int colCount = md.getColumnCount();
			while(rst.next()) {
				// 每一条记录，都存储在一个map中。
				Map<String, Object> m = new HashMap<>();
				for(int i=1; i<=colCount; i++) {// 遍历每列
					String name = md.getColumnLabel(i); // 取每列的名字
					Object value = rst.getObject(i); // 取系列的值
					m.put(name, value);
				}
				list.add(m);// 将记录加入到list中。
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return list;
	}
    private static int saveOrUpdate(String sql, Object... args) throws SQLException {
		int count = 0;

		Connection conn = null;
		PreparedStatement stm = null;

		try {
			conn = JdbcHelp.getConn();// 1
			stm = conn.prepareStatement(sql);// 2
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					stm.setObject(i + 1, args[i]);
				}
			}
			count = stm.executeUpdate(); // 3\ 4
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != stm)
				stm.close();
			if (null != conn)
				conn.close();
		}

		return count;
	}
    
    private static int saveOrUpdate(String sql) throws SQLException {
		int count = 0;

		Connection conn = null;
		Statement stm = null;

		try {
			conn = JdbcHelp.getConn();// 1
			stm = conn.createStatement();// 2
			
			count = stm.executeUpdate(sql); // 3\ 4
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != stm)
				stm.close();
			if (null != conn)
				conn.close();
		}

		return count;
	}
	
	
}
