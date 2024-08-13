package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.practice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
