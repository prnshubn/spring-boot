package com.spring.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.dao.CourseManagementDAO;
import com.spring.practice.entities.Course;

@Service
public class CourseManagementServiceImpl implements CourseManagementService
{
	@Autowired
	private CourseManagementDAO courseManagementDAO;
	
	@Override
	public List<Course> getCourses()
	{
		return courseManagementDAO.findAll();
	}

	@Override
	public Course createCourse(Course course)
	{
		return courseManagementDAO.save(course);
	}

	@Override
	public Course readCourse(int id)
	{
		return courseManagementDAO.getReferenceById(id);
	}

	@Override
	public Course updateCourse(Course course)
	{
		return courseManagementDAO.save(course);
	}

	@Override
	public Course deleteCourse(int id)
	{
		Course course=courseManagementDAO.getReferenceById(id);
		courseManagementDAO.deleteById(id);
		return course;
	}
	
}
