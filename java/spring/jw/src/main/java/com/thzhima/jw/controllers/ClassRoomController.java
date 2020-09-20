package com.thzhima.jw.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thzhima.jw.beans.Building;
import com.thzhima.jw.beans.ClassRoom;
import com.thzhima.jw.service.BuildingService;
import com.thzhima.jw.service.ClassRoomService;

@RestController
public class ClassRoomController {

	@Autowired
	private Logger logger;
	
	@Autowired
	private ClassRoomService cs;
	
	@Autowired
	private BuildingService bs;
	
	@PostMapping("/addClassRoom")
	public Map add(@RequestBody ClassRoom room) {
		Map m = new HashMap();
		try {
			System.out.println("收到对象"+room);
			cs.add(room);
			
			m.put("result", "success");
		} catch (Exception e) {
		    logger.error(e.getMessage());
		    m.put("result", "fail");
		}

		return m;
	}
	
	@GetMapping("/building/{name}")
	public Building findByName(@PathVariable("name")String name) {
		Building b = null;
		b = this.bs.findByNmae(name);
		return b;
	}
	
	@GetMapping("/classRoom/{name}")
	public List<ClassRoom> findClass(@PathVariable("name") String name){
//		if("null".equals(name)) {
//			name = null;
//		}
		return this.cs.findByName(name);
	}
	
	@DeleteMapping("/classRoom/{id}")
	public Map deleteByID(@PathVariable("id") int id) {
		System.out.println("delete method--------------------");
		Map m = new HashMap();
		if(1==this.cs.delByID(id)) {
			m.put("sesult", "success");
		}else {
			m.put("result", "fail");
		}
		return m;
	}
	
	@PutMapping("/classRoom/{id}/{name}")
	public Map update() {
		Map m = new HashMap();
		return m;
	}
	
}
