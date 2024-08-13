package com.spring.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.practice.entities.Course;

public interface CourseManagementDAO extends JpaRepository<Course, Integer>
{

}
