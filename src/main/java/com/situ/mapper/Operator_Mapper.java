package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Operator;
import com.situ.utils.SearchInfo;

@Repository("Operator_Mapper")
public interface Operator_Mapper {
	
	@Select(value = "select * from operator")
	public List<Operator> selectall();
	
	@Select(value = "select * from operator ${where} ${limits}")
	public List<Operator> index(SearchInfo info);
	
	//添加管理员
	@Insert("insert into operator(nike,pass,name,sex,age) values(#{nike},'123',#{name},#{sex},#{age})")
	public int insert(Operator o);
	
	//重置密码
	@Update("update operator set pass='123' where id=#{id}")
	public void resetPass(int id);
	
	//修改管理员信息
	@Update("update operator set nike=#{nike},name=#{name},sex=#{sex},age=#{age} where id=#{id}")
	public void update(Operator o);
	
	//修改管理员信息
	@Update("delete from operator where id=#{id}")
	public void del(int id);
	
	@Select(value = "select * from operator where id=#{id}")
	public Operator getById(int id);
	
}
