package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.User;
import com.situ.utils.UserSearchInfo;

@Repository
public interface User_Mapper {
	
	@Select("select u.*,c.name cname from user u inner join course c on u.course_id=c.id ${where} order by u.id desc ${limits}")
	public List<User> select(UserSearchInfo info);
	
	@Select("select count(u.id) from user u inner join course c on u.course_id=c.id ${where} order by u.id desc ${limits}")
	public int count(UserSearchInfo info);
	
	@Insert("insert into user(nike,pass,name,sex,age,birthday,course_id,status,dress,times,comments) values(#{nike},'123',#{name},#{sex},#{age},#{birthday},#{course_id},#{status},#{dress},#{times},#{comments})")
	public int insert(User u);
	
	//修改学生信息
	@Update("update user set nike=#{nike},name=#{name},sex=#{sex},age=#{age},birthday=#{birthday},course_id=#{course_id},status=#{status},dress=#{dress},times=#{times},comments=#{comments} where id=#{id}")
	public int update(User u);
	
	//重置密码
	@Update("update user set pass='123' where id=#{id}")
	public int resetPass(int id);
	
	@Select(value = "select u.*,c.name cname from user u inner join course c on u.course_id=c.id where u.id=#{id}")
	public User getById(int id);
	
	@Delete("delete from user where id=#{id}")
	public int del(int id);
	
}
