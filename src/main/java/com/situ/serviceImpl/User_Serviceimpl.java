package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.User;
import com.situ.mapper.User_Mapper;
import com.situ.service.User_Service;
import com.situ.utils.UserSearchInfo;

@Service
public class User_Serviceimpl implements User_Service {

	@Autowired
	User_Mapper mapper;

	@Override
	public List<User> select(UserSearchInfo info) {
		return mapper.select(info);
	}

	@Override
	public int count(UserSearchInfo info) {
		return mapper.count(info);
	}

	@Override
	public int insert(User u) {
		return mapper.insert(u);
	}

	@Override
	public int update(User u) {
		return mapper.update(u);
	}

	@Override
	public User getById(int id) {
		return mapper.getById(id);
	}

	@Override
	public int del(int id) {
		return mapper.del(id);
	}

	@Override
	public int resetPass(int id) {
		return mapper.resetPass(id);
	}

	
}
