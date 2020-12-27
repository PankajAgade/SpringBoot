package com.radio.Controller.Reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radio.Etity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> 
{
	public Student findByUsername (String username);
}
