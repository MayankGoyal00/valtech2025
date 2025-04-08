package com.valtech.training.result.services;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valtech.training.result.vos.ResultVO;

@SpringBootApplication
public interface ResultService {

	List<ResultVO> getResultsByQuiz(Long quizId);

	List<ResultVO> getResultsByUser(String name);

	ResultVO saveResult(Long quizId, String userName, int score);

}
