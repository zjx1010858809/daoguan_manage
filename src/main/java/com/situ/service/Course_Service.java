package com.situ.service;

import java.util.List;

import com.situ.entity.Course;
import com.situ.utils.CourseSearchInfo;

public interface Course_Service {
	public List<Course> selectall();
	
	public List<Course> select(CourseSearchInfo info);
	
	public int insert(Course s);
	
	public int delete(int id);
	
	public int update(Course s);
	
	public Course getbyid(int id);
	
	public int getcount(CourseSearchInfo info);

}
