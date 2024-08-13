package com.spring.practice.services;

import java.util.List;

import com.spring.practice.entities.Course;

public interface CourseManagementService
{
	public List<Course> getCourses();
	public Course createCourse(Course course);
	public Course readCourse(int id);
	public Course updateCourse(Course course);
	public Course deleteCourse(int id);
}
