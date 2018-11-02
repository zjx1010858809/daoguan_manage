package com.situ.service;

import java.util.List;

import com.situ.entity.Operator;
import com.situ.utils.SearchInfo;

public interface Operator_Service {
	
	public List<Operator> selectall();
	
	public List<Operator> index(SearchInfo info);
	
	public int insert(Operator o);
	
	public void resetPass(int id);
	
	public void update(Operator o);
	
	public void del(int id);
	
	public Operator getById(int id); 
	
}
