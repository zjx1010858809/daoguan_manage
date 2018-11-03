package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Operator;
import com.situ.service.Operator_Service;
import com.situ.utils.JsonInfo;
import com.situ.utils.OperatorSearchInfo;
import com.situ.utils.SearchInfo;

@Controller
@RequestMapping("Operator")
public class Operator_Controller {

	@Autowired
	Operator_Service oservice;

	@RequestMapping("index")
	@ResponseBody
	public HashMap<String, Object> index(OperatorSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		// data
		ArrayList<Operator> list = new ArrayList<Operator>();
		
		if (info.getName()== null) {
			info.setWhere("");
		} else if (info.getName() == "") {
			info.setWhere("");
		} else {
			info.setWhere("where nike like '%" + info.getName() + "%'");
		}
		
		list = (ArrayList<Operator>) oservice.index(info);
		
		m.put("data", list);
		m.put("count", 0);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}

	// 添加管理员
	@RequestMapping("insert")
	protected @ResponseBody JsonInfo insert(Operator o) {
		int i = oservice.insert(o);
		if (i > 0) {
			return new JsonInfo(1, "添加成功！");
		} else {
			return new JsonInfo(0, "添加失败！");
		}
	}
	
	//修改管理员
	@RequestMapping("update")
	protected @ResponseBody JsonInfo update(Operator oper, ModelMap m) {
		oservice.update(oper);
		return new JsonInfo(1, "修改成功！");
	}
	
	//重置密码
	@RequestMapping("resetPass")
	protected @ResponseBody JsonInfo resetPass(int id) {
		oservice.resetPass(id);
		return new JsonInfo(1, "密码重置成功!");
	}
	
	//删除
	@RequestMapping("del")
	protected @ResponseBody JsonInfo del(int id) {
		oservice.del(id);
		return new JsonInfo(1, "删除成功!");
	}

	//进入修改页面
	@RequestMapping("operatorEdit")
	public ModelAndView testFreemarker(int id) throws Exception {
		ModelAndView mv = new ModelAndView();
		Operator oper = oservice.getById(id);
		mv.addObject("operator", oper);
		mv.setViewName("operator/operatorUpdate");
		return mv;
	}
}
