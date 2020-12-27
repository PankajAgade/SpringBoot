package com.radio.Controller.Reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radio.Etity.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> 
{

}
