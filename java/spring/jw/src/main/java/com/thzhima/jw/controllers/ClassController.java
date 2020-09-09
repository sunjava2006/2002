package com.thzhima.jw.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thzhima.jw.beans.Class;
import com.thzhima.jw.service.ClassService;

@Controller
public class ClassController {

	@Autowired
	private ClassService sc;
	
	@GetMapping("/*.html")
	public String classHtml(HttpServletRequest req) {
		String url = req.getRequestURI();
		System.out.println(url);
		url = url.substring(1, url.lastIndexOf("."));
		return url;
	}
	
	@RequestMapping(value="/addClass.do", method = RequestMethod.POST) //== @PostMapping
	public ModelAndView addClass(Class c, ModelAndView mv) {
		mv.setViewName("class");
		int count =0;
		try {
			count = sc.addClass(c);
		} catch (Exception e) {
			mv.addObject("msg", "添加失败");
		}
		
		if(1==count) {
			mv.addObject("msg", "添加成功");
		}else {
			mv.addObject("msg", "添加失败");
		}
		
		return mv;
	}
}
