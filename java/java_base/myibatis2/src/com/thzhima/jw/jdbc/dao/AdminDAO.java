package com.thzhima.jw.jdbc.dao;

import org.apache.ibatis.session.SqlSession;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.jdbc.SessionUtil;

public class AdminDAO implements AdminMapper{

	@Override
	public  AdminUser find(AdminUser us) {
		AdminUser u = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			AdminMapper impl = session.getMapper(AdminMapper.class);
			u = impl.find(us);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return u;
	}

	

	@Override
	public AdminUser find2(String loginName, String pwd) {
		AdminUser u = null;
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			AdminMapper impl = session.getMapper(AdminMapper.class);
			u = impl.find2(loginName, pwd);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return u;
	}
	
	@Override
	public int update(AdminUser u) {
		int count = 0;
		SqlSession s = null;
		try {
			s = SessionUtil.getSession();
			AdminMapper impl = s.getMapper(AdminMapper.class);
			count = impl.update(u);
			s.commit();
		} catch (Exception e) {
			s.rollback();
			throw e;
		} finally {
			if(null != s) {
				s.close();
			}
		}
		return count;
	}
	
	@Override
	public int insert(AdminUser u) {
		int count = 0;
		SqlSession s = null;
		try {
			s = SessionUtil.getSession();
			AdminMapper impl = s.getMapper(AdminMapper.class);
			count = impl.insert(u);
			s.commit();
		} catch (Exception e) {
			s.rollback();
			throw e;
		} finally {
			if(null != s) {
				s.close();
			}
		}
		return count;
	}
	
	
	@Override
	public int updateByExample(AdminUser u) {
		int count = 0;
		SqlSession s = null;
		try {
			s = SessionUtil.getSession();
			AdminMapper impl = s.getMapper(AdminMapper.class);
			count = impl.updateByExample(u);
			s.commit();
		} catch (Exception e) {
			s.rollback();
			throw e;
		} finally {
			if(null != s) {
				s.close();
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		AdminDAO dao = new AdminDAO();
		AdminUser u = dao.find2("admin", "123456");
		u.setLoginName(null);
//		System.out.println(u);
//		u.setPwd("123456");
//		System.out.println(dao.update(u));
		
//		AdminUser uu = new AdminUser(null, "Zhang", "123456");
//		System.out.println(dao.insert(uu));
		
		dao.updateByExample(u);
	}



	



	



	
}
