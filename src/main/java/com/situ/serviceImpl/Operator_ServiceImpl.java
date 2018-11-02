package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Operator;
import com.situ.mapper.Operator_Mapper;
import com.situ.service.Operator_Service;
import com.situ.utils.SearchInfo;

@Service
public class Operator_ServiceImpl implements Operator_Service{
	
	@Autowired
	Operator_Mapper odao;

	@Override
	public List<Operator> selectall() {
		return odao.selectall();
	}

	@Override
	public List<Operator> index(SearchInfo info) {
		return odao.index(info);
	}

	@Override
	public int insert(Operator o) {
		return odao.insert(o);
	}

	@Override
	public void resetPass(int id) {
		odao.resetPass(id);
	}

	@Override
	public void update(Operator o) {
		odao.update(o);
	}

	@Override
	public Operator getById(int id) {
		return odao.getById(id);
	}

	@Override
	public void del(int id) {
		odao.del(id);
	}
	
	
}
