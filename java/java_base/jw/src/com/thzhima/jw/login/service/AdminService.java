package com.thzhima.jw.login.service;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.jdbc.dao.AdminDAO;

public class AdminService {

	public static AdminUser adminLogin(String loginName, String pwd) throws Exception {
		return AdminDAO.find(loginName, pwd);
	}
}
