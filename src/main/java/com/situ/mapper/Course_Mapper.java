package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Course;
import com.situ.utils.CourseSearchInfo;

@Repository
public interface Course_Mapper {
	
	@Select("select * from course order by id desc")
	public List<Course> selectall();
	
	@Select("select * from course ${where} order by id desc ${limits}")
	public List<Course> select(CourseSearchInfo info);
	
	@Insert("insert into course (name,parent_id,comments) values(#{name},#{parent_id},#{comments})")
	public int insert(Course c);
	
	@Delete("delete from course where id=#{id}")
	public int delete(int id);
	
	@Update("update course set name=#{name},parent_id=#{parent_id},comments=#{comments} where id=#{id}")
	public int update(Course c);
	
	@Select("select * from course where id=#{id}")
	public Course getbyid(int id);
	
	@Select("select count(id) from course ${where} order by id desc ${limits}")
	public int getcount(CourseSearchInfo info);

}
