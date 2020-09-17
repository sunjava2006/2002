package com.thzhima.jw.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
			cs.add(room);
			m.put("result", "success");
		} catch (Exception e) {
		    logger.error(e.getMessage());
		    m.put("result", "fail");
		}

		return m;
	}
	
	@GetMapping("/classRoom/{name}")
	public Building findByName(@PathVariable("name")String name) {
		Building b = null;
		b = this.bs.findByNmae(name);
		return b;
	}
}
