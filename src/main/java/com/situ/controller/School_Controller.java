package com.situ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.service.Course_Service;

@Controller
@RequestMapping("Activity_School")
public class School_Controller {
	@Autowired
	Course_Service sservice;
	
	//进入正文
		@RequestMapping("index")
		public ModelAndView def() throws Exception {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("activity_school/index");
			return mv;
		}
	
	
	

}
