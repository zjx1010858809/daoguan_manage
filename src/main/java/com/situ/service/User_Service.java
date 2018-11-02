package com.situ.service;

import java.util.List;

import com.situ.entity.User;
import com.situ.utils.UserSearchInfo;

public interface User_Service {
	public List<User> select(UserSearchInfo info);
	
	public int count(UserSearchInfo info);
	
	public int insert(User u);
	
	public int update(User u);
	
	public User getById(int id);
}
