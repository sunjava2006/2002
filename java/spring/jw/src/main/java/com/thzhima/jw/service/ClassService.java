package com.thzhima.jw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thzhima.jw.beans.Class;
import com.thzhima.jw.dao.ClassDAO;
import com.thzhima.jw.dao.StudentDAO;

@Service
public class ClassService {

	@Autowired
	private ClassDAO classDao;
	
	@Autowired
	private StudentDAO studentDao;
	
	/**
	 * 添加班级
	 * @param c
	 * @return
	 */
	public int addClass(Class c) {
		return this.classDao.insert(c);
	}
	
	/**
	 * 分页查询
	 * @param c
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Class> query(Class c, int page, int size){
		return this.classDao.queryByExample(c, page, size);
	}
	
    /**
           * 查询条件匹配的记录数
     * @param c
     * @return
     */
    public int countByExam(Class c) {
    	return this.classDao.countByExample(c);
    }
    
    /**
           * 根据总记录数，和分页大小，计算页数。
     * @param total
     * @param size
     * @return
     */
    public int pages(double total, int size) {
    	return (int)Math.ceil(total/size);
    }
    
    /**
          * 根据班级ID,删除班级
     * @param id
     * @return
     */
    @Transactional
    public int delByID(int id) {
    	// 删除学生
    	this.studentDao.delByClassID(id);
    	// 删除班级
    	return this.classDao.delByID(id);
    }
    
    /**
            * 修改班级信息
     * @param c
     * @return
     */
    public int modifyClassInfo(Class c) {
    	return this.classDao.updateByExample(c);
    }
    
    public List<Class> listAll(){
    	return this.classDao.listAll();
    }
}
