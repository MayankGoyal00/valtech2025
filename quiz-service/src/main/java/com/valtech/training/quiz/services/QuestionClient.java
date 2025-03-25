package com.valtech.training.quiz.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quiz.entities.QuestionWrapper;
import com.valtech.training.quiz.entities.Response;

@Service
public class QuestionClient {
	
	private final String URL="http://localhost:9060/api/v1/questions";
	private final RestTemplate restTemplate =new RestTemplate();
	
	public List<Integer> getQuestionsForQuiz(String topic, long numQuestions) {
        String url = URL + "/generate?topicName=" + topic + "&numQuestions=" + numQuestions;
        return restTemplate.getForObject(url, List.class);
    }
 
    public List<QuestionWrapper> getQuestionsFromId(List<Integer> questionIds) {
        String url = URL + "/getQuestions";
        return restTemplate.postForObject(url, questionIds, List.class);
    }
 
    public int getScore(List<Response> responses) {
        String url = URL + "/getScore";
        return restTemplate.postForObject(url, responses, Integer.class);
    }

	
}

 
  