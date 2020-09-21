package com.thzhima.jw.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thzhima.jw.beans.Class;
import com.thzhima.jw.beans.ClassRoom;
import com.thzhima.jw.beans.Subject;
import com.thzhima.jw.beans.SubjectPlan;
import com.thzhima.jw.beans.Times;
import com.thzhima.jw.service.ClassRoomService;
import com.thzhima.jw.service.ClassService;
import com.thzhima.jw.service.SubjectPlanService;
import com.thzhima.jw.service.SubjectService;
import com.thzhima.jw.service.TimesService;



@RestController
public class ApplySubjectController {

	@Autowired
	private ClassService cs;
	
	@Autowired
	private ClassRoomService crs;
	
	@Autowired
	private TimesService ts;
	
	@Autowired
	private SubjectService ss;
	
	@Autowired
	private SubjectPlanService sps;
	
	@GetMapping("/initData")
	public Map init() {
		Map map = new HashMap();
		
		List<Class> classList = this.cs.listAll();
		List<ClassRoom> classRoomList = crs.listAll();
		List<Times> timesList = ts.listAll();
		List<Subject> subjectList = ss.listAll();
		
		map.put("classList", classList);
		System.out.println(classList);
		map.put("classRoomList", classRoomList);
		map.put("timesList", timesList);
		map.put("subjectList", subjectList);
		
		return map;
	}
	
	@PostMapping("/applySubject")
	public Map add(SubjectPlan sp) {
		Map m = new HashMap();
		
		if(1==sps.add(sp)) {
			m.put("result", "success");
		}else {
			m.put("result", "fail");
		}
		
		
		return m;
	}
}
