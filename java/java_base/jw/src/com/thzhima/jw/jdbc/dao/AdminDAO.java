package com.thzhima.jw.jdbc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.thzhima.jw.beans.AdminUser;
import com.thzhima.jw.jdbc.MybatisTemplate;


public class AdminDAO {
	
	public static int count() throws Exception{
		String selid = AdminUser.class.getName()+".count";
		return MybatisTemplate.findOne(selid);
	}
	
	public static AdminUser find(String loginName, String pwd) throws Exception{
		return MybatisTemplate.findOne(AdminUser.class.getName()+".login", new AdminUser(null,loginName,pwd));
	}
	
	public static AdminUser findByID(int id) throws Exception{
		
		return MybatisTemplate.findOne(AdminUser.class.getName()+".findByID", id);
	}
	
	public static List<AdminUser> listAll(){
		
		return MybatisTemplate.findList(AdminUser.class.getName()+".listAll");
	}
	
	public static List<AdminUser> listByPage(int page, int size){
			Map<String, Integer> map = new HashMap<>();
			map.put("from", (page-1)*size);
			map.put("to", page*size);
			return MybatisTemplate.findList(AdminUser.class.getName()+".listByPage", map);
			
	}
	
	public static int add(AdminUser u) {
		String sqlID = AdminUser.class.getName()+".add";
		return MybatisTemplate.insert(sqlID, u);
	}
	
	public static int update(AdminUser u) {
		String sqlID = AdminUser.class.getName()+".updatePWD";
		return MybatisTemplate.insert(sqlID, u);
	}
	
	public static int delete(int id) {
		String sqlID = AdminUser.class.getName()+".delByID";
		return MybatisTemplate.delete(sqlID, id);
	}
	
	public static void main(String[] args) throws Exception {
		AdminUser u = findByID(90);
		System.out.println(u);
		
//		u.setPwd("123456");
//		update(u);
		
		u = findByID(90);
		System.out.println(u);
		
//		u.setPwd("ABCabc");
//		System.out.println(update(u));
//		System.out.println(delete(100));
	}
}
