package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Course;
import com.situ.mapper.Course_Mapper;
import com.situ.service.Course_Service;
import com.situ.utils.CourseSearchInfo;

@Service
public class Course_ServiceImpl implements Course_Service {
	@Autowired
	Course_Mapper mapper;

	@Override
	public List<Course> selectall() {
		return mapper.selectall();
	}

	@Override
	public List<Course> select(CourseSearchInfo info) {
		return mapper.select(info);
	}

	@Override
	public int insert(Course c) {
		return mapper.insert(c);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public int update(Course c) {
		return mapper.update(c);
	}

	@Override
	public Course getbyid(int id) {
		return mapper.getbyid(id);
	}

	@Override
	public int getcount(CourseSearchInfo info) {
		return mapper.getcount(info);
	}

	

}
