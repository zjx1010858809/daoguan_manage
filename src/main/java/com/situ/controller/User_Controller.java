package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.entity.User;
import com.situ.service.School_Service;
import com.situ.service.User_Service;
import com.situ.utils.UserSearchInfo;

@Controller
@RequestMapping("User")
public class User_Controller {
	@Autowired
	User_Service service;
	@Autowired
	School_Service sservice;

	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> select(UserSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		
		// 查询
		

		// data
		
		ArrayList<User> list = new ArrayList<User>();
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
}
