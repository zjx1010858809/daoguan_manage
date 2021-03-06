package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Course;
import com.situ.entity.User;
import com.situ.service.Course_Service;
import com.situ.service.User_Service;
import com.situ.utils.JsonInfo;
import com.situ.utils.UserSearchInfo;

@Controller
@RequestMapping("User")
public class User_Controller {
	@Autowired
	User_Service service;
	@Autowired
	Course_Service cservice;

	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> select(UserSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<User> list = new ArrayList<User>();
		
		// 查询
		Integer course_id=info.getCourse_id();
		String uname=info.getUname();
		
		if(course_id==null&&uname==null) {
			info.setWhere(" where u.course_id=(select max(id) from course) ");
		}else if(course_id!=null&&uname==null) {
			info.setWhere(" where u.course_id="+course_id+" ");
		}else if(course_id!=null&&uname!=null) {
			info.setWhere(" where u.course_id="+course_id+" and u.name like '%"+uname+"%' ");
		}

		// data
		list = (ArrayList<User>) service.select(info);

		// count
		int count=service.count(info);

		// Response
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
	//自动填充课程
	@RequestMapping("course")
	@ResponseBody
	public List<Course> course(){
		return cservice.selectall();
	}
	
	//进入新增页面
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView m=new ModelAndView();
		
		m.addObject("courselist",cservice.selectall());
		m.setViewName("users/studentUpdate");
		return m;
	}
	
	//新增
	@RequestMapping("insert")
	public @ResponseBody JsonInfo insert(User u) {
		int i=service.insert(u);
		if(i==1) {
			return new JsonInfo(1, "新增成功");
		}else {
			return new JsonInfo(0,"请重新操作");
		}
	}
	
	//进入修改页面
	@RequestMapping("edit")
	public ModelAndView edit(int id) {
		ModelAndView m=new ModelAndView();
		User user=service.getById(id);
		m.addObject("userUpdate",user);
		m.addObject("courselist",cservice.selectall());
		m.setViewName("users/studentUpdate");
		return m;
	}
	
	//修改
	@RequestMapping("update")
	public @ResponseBody JsonInfo update(User u) {
		int i=service.update(u);
		if(i==1) {
			return new JsonInfo(1,"修改成功");
		}else {
			return new JsonInfo(0,"请重新操作");
		}
	}
	
	//删除
	@RequestMapping("del")
	public @ResponseBody JsonInfo del(int id) {
		int l=service.del(id);
		if(l==1){
			return new JsonInfo(1,"删除成功");
		}else {
			return new JsonInfo(0,"请重新操作");
		}		
	}
	
	//重置密码
	@RequestMapping("resetPass")
	protected @ResponseBody JsonInfo resetPass(int id) {
		int r=service.resetPass(id);
		if(r==1) {
			return new JsonInfo(1, "密码重置成功!");
		}else {
			return new JsonInfo(0, "请重新操作!");
		}
		
	}
}
