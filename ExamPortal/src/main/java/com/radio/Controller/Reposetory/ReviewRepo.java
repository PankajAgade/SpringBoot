package com.radio.Controller.Reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radio.Etity.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer>
{
	public List<Review> findByStudentIdAndTestId(int sid, int tid);
}
