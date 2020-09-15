package com.thzhima.jw.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thzhima.jw.beans.Class;
import com.thzhima.jw.service.ClassService;

@Controller
public class ClassController {

	@Value("${page.size}")
	private int pageSize;
	
	@Autowired
	private ClassService cs;
	
	@GetMapping("/*.htm")
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
			count = cs.addClass(c);
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
	
	@RequestMapping(value = "/queryClass.do" , method = {RequestMethod.POST, RequestMethod.GET})
	public String query(Class c, 
			            @RequestParam(name="currentPage", required=false, defaultValue = "1")int page ,
			            ModelMap mm) {
		List<Class> list = this.cs.query(c, page, this.pageSize);
		int totalCount = this.cs.countByExam(c);
		int totalPage = this.cs.pages(totalCount, this.pageSize);
		
		mm.addAttribute("list", list);
		mm.addAttribute("totalCount", totalCount);
		mm.addAttribute("totalPage", totalPage);
		mm.addAttribute("currentPage", page);
		mm.addAttribute("classNO", c.getClassNO());
		mm.addAttribute("className", c.getClassName());
		
		System.out.println("pageSize:"+this.pageSize);
		return "class";
	}
	
	@RequestMapping("/delClass.do")
	public String delClass(@RequestHeader(name = "Referer")String referer, int id) {
		System.out.println(referer);
		this.cs.delByID(id);
		return "redirect:"+referer;
	}
	
	@PostMapping("/modifyClass.do")
	public String modifyClass(@RequestHeader("Referer")String referer, Class c ) {
		this.cs.modifyClassInfo(c);
		return "redirect:"+referer;
	}
}
