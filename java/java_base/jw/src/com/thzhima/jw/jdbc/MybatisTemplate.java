package com.thzhima.jw.jdbc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;



public class MybatisTemplate {
	
	
	public static  List<Map> findMapList(String selectID) {
		List<Map> list = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			list = session.selectList(selectID);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return list;
	}
	
	public static  List<Map> findMapList(String selectID, Object arg) {
		List<Map> list = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			list = session.selectList(selectID, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return list;
	}
	


	public static <T> T findOne(String selectID, Object arg) {
		T t = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			t = session.selectOne(selectID, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return t;
	}
	
	public static <T> T findOne(String selectID) {
		T t = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			t = session.selectOne(selectID);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return t;
	}
	public static <T> List<T> findList(String selectID) {
		List<T> list = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			list = session.selectList(selectID);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return list;
	}
	
	public static <T> List<T> findList(String selectID, Object arg) {
		List<T> list = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			list = session.selectList(selectID, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return list;
	}
	
	public static int insert(String sqlID, Object arg) {
		int count = 0;
		SqlSession session  = null;
		try {
			session = SessionUtil.getSession();
			count = session.insert(sqlID, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		} 
		return count;
	}
	
	public static int update(String sqlID, Object arg) {
		int count = 0;
		SqlSession session  = null;
		try {
			session = SessionUtil.getSession();
			count = session.update(sqlID, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		} 
		return count;
	}
	
	public static int delete(String sqlID, Object arg) {
		int count = 0;
		SqlSession session  = null;
		try {
			session = SessionUtil.getSession();
			count = session.delete(sqlID, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		} 
		return count;
	}
	
	public static int insert(String sqlID) {
		int count = 0;
		SqlSession session  = null;
		try {
			session = SessionUtil.getSession();
			count = session.insert(sqlID);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		} 
		return count;
	}
	
	public static int update(String sqlID) {
		int count = 0;
		SqlSession session  = null;
		try {
			session = SessionUtil.getSession();
			count = session.update(sqlID);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		} 
		return count;
	}
	
	public static int delete(String sqlID) {
		int count = 0;
		SqlSession session  = null;
		try {
			session = SessionUtil.getSession();
			count = session.delete(sqlID);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		} 
		return count;
	}
	
	public static void main(String[] args) {
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			Object o = session.selectMap("listAllMap","ID");
			session.commit();
			System.out.println(o);
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
	}
}
