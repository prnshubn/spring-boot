package com.spring.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.practice.entities.Course;
import com.spring.practice.services.CourseManagementService;

@RestController
public class CourseManagementController
{
	@Autowired
	private CourseManagementService courseManagementService;
	
	//read all courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseManagementService.getCourses();
	}
	
	//add new course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseManagementService.createCourse(course);
	}
	
	//read course by id
	@GetMapping("/courses/{id}")
	public Course readCourse(@PathVariable int id)
	{
		return this.courseManagementService.readCourse(id);
	}
	
	//update course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseManagementService.updateCourse(course);
	}
	
	//delete course
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int id)
	{
		try
		{
			this.courseManagementService.deleteCourse(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
