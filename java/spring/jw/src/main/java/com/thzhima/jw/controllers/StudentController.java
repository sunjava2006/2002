package com.thzhima.jw.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thzhima.jw.beans.Student;
import com.thzhima.jw.service.StudentService;

@Controller
public class StudentController {

	@Value("${upload.file.path}")
	private String path;
	
	@Autowired
	private StudentService ss;
	
	@PostMapping("/addStu.do")
	public String addStu(Student student,@RequestParam("photo1") MultipartFile photo1, ModelMap mm) throws IllegalStateException, IOException {
		
		
		int count = 0;
		try {
			String fileName = photo1.getOriginalFilename();
			fileName = fileName.substring(fileName.lastIndexOf("."));
			fileName = System.currentTimeMillis()+fileName;
			System.out.println(fileName);
			photo1.transferTo(new File(this.path, fileName));
			student.setPhoto(fileName);
			count = ss.addStudent(student);
		} catch (Exception e) {
			mm.addAttribute("msg", "添加失败");
			e.printStackTrace();
		}
		if(count==1) {
			mm.addAttribute("msg", "添加成功");
		}else {
			mm.addAttribute("msg", "添加失败");
		}
		
		
		return "student";
	}
}
