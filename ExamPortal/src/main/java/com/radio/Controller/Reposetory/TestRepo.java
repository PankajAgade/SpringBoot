package com.radio.Controller.Reposetory;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.radio.Etity.Test;

public interface TestRepo extends JpaRepository<Test, Integer>
{
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO test_questions (`tests_id`, `questions_id`) VALUES (?1, ?2)", nativeQuery = true)
	public void abcd(int testid , int qid);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM test_questions WHERE (`tests_id` = ?1) and (`questions_id` = ?2)", nativeQuery = true)
	public void abcdremovequestion(int testid , int qid);
}
