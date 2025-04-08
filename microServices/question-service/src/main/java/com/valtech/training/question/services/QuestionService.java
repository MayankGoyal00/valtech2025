package com.valtech.training.question.services;

import java.util.List;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valtech.training.question.entities.QuestionWrapper;
import com.valtech.training.question.entities.Response;
import com.valtech.training.question.vos.QuestionVO;

@SpringBootApplication
public interface QuestionService {

	QuestionVO getQuestion(long id);

	List<QuestionVO> getAllQuestion();

	QuestionVO saveQuestion(QuestionVO q);

	QuestionVO updateQuestion(QuestionVO q, long id);

	List<Long> getQuestionForQuiz(String topic, long num);

	List<QuestionVO> getQuestionByTopic(String topic);

	int getScoreForQuiz(List<Response> responses);

	List<QuestionWrapper> getQuestionsFromId(List<Long> questionId);



	

}
