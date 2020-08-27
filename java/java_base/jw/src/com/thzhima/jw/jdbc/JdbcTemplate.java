package com.thzhima.jw.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTemplate {

	public static <T> T select(String sql, ResultSetExtractor<T> ext, Object...args) throws Exception {
		T t = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		
		try {
			conn = ConnUtil.getConn();
			stm =  conn.prepareStatement(sql);
			if(args != null) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			
			rst = stm.executeQuery();
			t = ext.extract(rst);
		} catch (Exception e) {
		    throw e;
		} finally{
			if(rst != null) {
				rst.close();
			}
			if(stm != null) {
				stm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return t;
	}
	
	public static  int saveOrUpdate(String sql, Object...args) throws Exception {
		int count = 0;
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnUtil.getConn();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			if(null != args) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			
			count = stm.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			if(null!=stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		return count;
	}
	
	public static int[] executePatch(String ...sqls) throws Exception {
		int[] count = null;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnUtil.getConn();
			conn.setAutoCommit(false);
			stm = conn.createStatement();
			
			for(String sql : sqls) {
				stm.addBatch(sql); // 将多条语句加入到语句对象中。
			}
			
			count=stm.executeBatch(); // 执行批处理语句
			
			
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			if(null!=stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		return count;
	}
}
