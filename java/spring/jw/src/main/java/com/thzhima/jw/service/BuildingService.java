package com.thzhima.jw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.jw.beans.Building;
import com.thzhima.jw.dao.BuildingDAO;

@Service
public class BuildingService {

	@Autowired
	private BuildingDAO bd;
	
	
	public int add(Building b) {
		return bd.insert(b);
	}
	
	public List<Building> listByPage(String name, int page, int size){
		return bd.listByPage(name, page, size);
	}
	
	public int count(String name) {
		return bd.count(name);
	}
	
	public int totalPage(double totalCount, int size) {
		return (int)(Math.ceil(totalCount / size));
	}
	
	public int deleteByID(int id) {
		return this.bd.delByID(id);
	}
	
	
	public int update(Building b) {
		return this.bd.updateByExample(b);
	}
	
	public Building findByNmae(String name) {
		return this.bd.findByName(name);
	}
}
