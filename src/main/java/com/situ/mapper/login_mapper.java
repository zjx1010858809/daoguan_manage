package com.situ.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.situ.entity.Login;


@Repository("login_mapper")
public interface login_mapper {
	
	
	@Select("select * from user where nike=#{nike} and pass=#{pass}")
	public Login userLogin(Login log);
	
	@Select("select * from operator where nike=#{nike} and pass=#{pass}")
	public Login operLogin(Login log);
	
}
