package com.thzhima.jw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.jw.beans.ClassRoom;
import com.thzhima.jw.dao.ClassRoomDAO;

@Service
public class ClassRoomService {
    @Autowired
    private ClassRoomDAO dao;
    
    public int add(ClassRoom room) {
    	return dao.add(room);
    }
    
    public List<ClassRoom> findByName(String name){
    	return dao.findByName(name);
    }
    
    public int delByID(int id) {
    	return this.dao.delByID(id);
    }
}
