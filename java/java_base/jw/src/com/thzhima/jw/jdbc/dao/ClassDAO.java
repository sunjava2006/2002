package com.thzhima.jw.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import com.thzhima.jw.beans.Class;
import com.thzhima.jw.jdbc.JdbcTemplate;
import com.thzhima.jw.jdbc.ResultSetExtractor;

public class ClassDAO {

	public static int[] delByID(int classID) throws Exception {
		String delStu = "delete from t_students where class_id="+classID;
		String delClass = "delete from t_classes where id="+classID;
		
		return JdbcTemplate.executePatch(delStu, delClass);
	}
	
	public static int insert(String classNO, String className) throws Exception {
		int count = 0;
		String sql ="insert into t_classes values (seq_class.nextval, ?, ?)";
		count = JdbcTemplate.saveOrUpdate(sql, classNO, className);
		return count;
	}
	
	public static int queryByKeyCount(String classNO, String className) throws Exception {
		int c = 0;
		ResultSetExtractor<Integer> ext = (rst)->{
			rst.next();
			return rst.getInt(1);
		};
		if(classNO==null && className==null) {
			String sql = "select count(*) from t_classes ";
			c = JdbcTemplate.select(sql, ext);
		}
		else if(classNO!=null && className!=null) {
			String sql ="select count(*) from t_classes a where class_no like ? or class_name like ? " ;
			c = JdbcTemplate.select(sql, ext, classNO, className);
			
		}else if(classNO!=null && className==null) {
			String sql = "select count(*) from t_classes a where class_no like ?  " ;
			c = JdbcTemplate.select(sql, ext, classNO);
		}else if(classNO==null && className!=null) {
			String sql = "select count(*) from t_classes a where  class_name like ?" ;
			c = JdbcTemplate.select(sql, ext, className);
		}
		return c;
	}
	
	public static List<Class> queryByKey(String classNO, String className, int page, int size) throws Exception{
		List<Class> li = null;
		
		ResultSetExtractor<List<Class>> ext = (rst)->{
			List<Class> list = new ArrayList<>();
			while(rst.next()) {
				int id = rst.getInt("id");
				String no = rst.getString("class_no");
				String name = rst.getString("class_name");
				Class c = new Class(id, no, name);
				list.add(c);
			}
			return list;
			
		};
		
		int start = (page-1)*size;
		int end = page*size;
		
		if(classNO==null && className==null) {
			String sql = "select * from (" 
		                +"select a.*, rownum ro from(select * from t_classes order by class_no desc)a where rownum <=?)" 
					    +"where ro>?";
			li = JdbcTemplate.select(sql, ext, end, start);
		}
		else if(classNO!=null && className!=null) {
			String sql = "select * from(" + 
					"select a.* , rownum ro from t_classes a where (class_no like ? or class_name like ?) and rownum <=?)" + 
					"where ro >?";
			li = JdbcTemplate.select(sql, ext, classNO, className, end, start);
			
		}else if(classNO!=null && className==null) {
			String sql = "select * from(" + 
					"select a.* , rownum ro from t_classes a where class_no like ?  and rownum <=?)" + 
					"where ro >?";
			li = JdbcTemplate.select(sql, ext, classNO, end, start);
		}else if(classNO==null && className!=null) {
			String sql = "select * from(" + 
					"select a.* , rownum ro from t_classes a where  class_name like ? and rownum <=?)" + 
					"where ro >?";
			li = JdbcTemplate.select(sql, ext, className, end, start);
		}
		
		return li;
	}

	public static int updateByID(String classNO, String className, int id) throws Exception {
		String sql = "update t_classes set class_no=?, class_name=? where id=?";
		return JdbcTemplate.saveOrUpdate(sql, classNO, className, id);
	}
}
