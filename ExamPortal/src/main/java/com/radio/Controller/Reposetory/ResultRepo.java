package com.radio.Controller.Reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radio.Etity.Result;

public interface ResultRepo extends JpaRepository<Result, Integer> 
{
	public List<Result> findByStudentId(int id);
}
