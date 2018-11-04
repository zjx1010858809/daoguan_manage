package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.standard.Severity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Course;
import com.situ.service.Course_Service;
import com.situ.utils.CourseSearchInfo;
import com.situ.utils.JsonInfo;

@Controller
@RequestMapping("Course")
public class Course_Controller {
	@Autowired
	Course_Service service;
	
	
	//自动填充数据
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> select(CourseSearchInfo info) {
		HashMap<String, Object> m=new HashMap<String, Object>();
		ArrayList<Course> course=new ArrayList<Course>();
		
		String name=info.getName();
		if(name==null) {
			info.setWhere(" ");
		}else {
			info.setWhere(" where name like '%"+name+"%'");
		}
		
		course=(ArrayList<Course>) service.select(info);
		int count=service.getcount(info);
		
		m.put("data",course);
		m.put("count",count);
		m.put("msg","");
		m.put("code",0);
		return m;
	}
	
	//进入新增页面
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView m=new ModelAndView();
		
		m.setViewName("course/edit");
		return m;
	}
	
	//新增
	@RequestMapping("insert")
	@ResponseBody
	public JsonInfo insert(Course c) {
		int i=service.insert(c);
		if(i==1) {
			return new JsonInfo(1,"新增成功");
		}else {
			return new JsonInfo(0,"请重新操作");
		}
	}
	
	//进入修改页面
	@RequestMapping("edit")
	public ModelAndView edit(int id) {
		ModelAndView m=new ModelAndView();
		Course course=service.getbyid(id);
		
		m.addObject("courselist",course);		
		m.setViewName("course/edit");
		return m;
	}
	
	//修改
	@RequestMapping("update")
	@ResponseBody
	public JsonInfo update(Course c) {
		int i=service.update(c);
		if(i==1) {
			return new JsonInfo(1,"修改成功");
		}else {
			return new JsonInfo(1,"修改成功");
		}
	}
	
	//删除
	@RequestMapping("delete")
	public @ResponseBody JsonInfo delete(int id) {
		int i=service.delete(id);
		if(i==1) {
			return new JsonInfo(1,"删除成功");
		}else {
			return new JsonInfo(0,"请重新操作");
		}
	}
	

}
