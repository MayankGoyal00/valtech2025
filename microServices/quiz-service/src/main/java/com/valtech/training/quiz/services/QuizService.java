package com.valtech.training.quiz.services;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valtech.training.quiz.entities.QuestionWrapper;
import com.valtech.training.quiz.entities.Response;
import com.valtech.training.quiz.vos.QuizVO;

@SpringBootApplication
public interface QuizService {
	
	QuizVO createQuiz(String topic, int num,String title);
	List<QuestionWrapper> getQuizQuestions(Long quizId);
	int calculateResult(Long quizId, List<Response> responses, String userName);
	

}
