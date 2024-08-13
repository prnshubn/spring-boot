package com.spring.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.model.Student;
import com.spring.practice.repository.StudentRepository;

@Service
public class StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public void deleteStudentById(int studentId)
	{
		studentRepository.deleteById(studentId);
	}
	
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Student editStudent(Student student,int studentId)
	{
		Student s=studentRepository.getById(studentId);
		s.setFirstName(student.getFirstName());
		s.setLastName(student.getLastName());
		s.setEmail(student.getEmail());
		return studentRepository.save(s);
	}
}
