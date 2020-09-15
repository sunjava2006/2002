package com.thzhima.jw.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thzhima.jw.beans.Building;
import com.thzhima.jw.service.BuildingService;

@RestController
public class BuildingController {

	@Value("${page.size}")
	private int size;
	
	@Autowired
	private BuildingService bs;
	
	@PostMapping("/addBuilding.do")
	public Map addBuild(Building b) {
		Map m = new HashMap();
		int i = 0;
		try {
			i = bs.add(b);
		}catch(Exception ex) {
			m.put("result", "添加失败");
		}
		if(i==1) {
			m.put("result", "添加成功");
		}
		
		return m;
	}
	
	@PostMapping("/searchBuilding.do")
	public Map search(String name,@RequestParam(name = "page", required = false, defaultValue = "1") int page) {
		Map map = new HashMap();
		List<Building> list = bs.listByPage(name, page, size);
		int totalCount = bs.count(name);
		int totalPage = bs.totalPage(totalCount, size);
		map.put("data", list);
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPage);
		map.put("currentPage", page);
		return map;
	}
	
}
