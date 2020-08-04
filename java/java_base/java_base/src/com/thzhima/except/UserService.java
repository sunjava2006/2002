package com.thzhima.except;

import javax.naming.NameNotFoundException;

public class UserService {

	void login(String userName, String pwd) throws LoginException, NameNotFoundException{
	
		if("admin".equals(userName) && "123".equals(pwd)) {
			throw new LoginException("数据库连接不同，登录 失败");
		}else {
			throw new NameNotFoundException();
		}
		
	}
	
	public static void main(String[] args) {
		UserService us = new UserService();
		try {
			int a = 1/(int)(Math.random()*10);
			us.login("admin", "123");
			
		}catch(LoginException ex) {
			System.out.println(ex);
		}
		catch(NameNotFoundException ex) {
			System.out.println(ex);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
}
