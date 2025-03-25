package com.valtech.training.result.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.result.entities.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Long>{

	List<Result> findByName(String name);
	List<Result> findByQuizId(Long quizId);
}
