package com.spring.practice.controller;

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

import com.spring.practice.model.Student;
import com.spring.practice.service.StudentService;

@RestController
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		try
		{
			Student newStudent=studentService.saveStudent(student);
			return new ResponseEntity<Student>(newStudent,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Student>(student,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		List<Student> list=studentService.getAllStudents();
		if(!list.isEmpty())
			return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		else
			return new ResponseEntity<List<Student>>(list,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudentById(@PathVariable Integer studentId)
	{
		try
		{
			studentService.deleteStudentById(studentId);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/students/{studentId}")
	public ResponseEntity<Student> editStudent(@RequestBody Student student,@PathVariable Integer studentId)
	{
		try
		{
			Student newStudent=studentService.editStudent(student, studentId);
			return new ResponseEntity<Student>(newStudent,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Student>(student,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}