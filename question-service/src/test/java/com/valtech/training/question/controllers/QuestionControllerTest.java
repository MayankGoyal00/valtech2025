package com.valtech.training.question.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;


import com.valtech.training.question.vos.QuestionVO;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuestionControllerTest {
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void addingQuestion() {
		List qu= restTemplate.getForObject("http://localhost:"+port+"/api/v1/questions/", List.class);
		
		if(qu.size()==0) {
			
			System.out.println("question adding ....");
			
			QuestionVO qu1=restTemplate.postForObject
					("http://localhost:"+port+"/api/v1/questions/",new QuestionVO(0, "What is 2+2?", "5", "4", "1", "2", "4", "Maths"),QuestionVO.class);
			QuestionVO qu2=restTemplate.postForObject
					("http://localhost:"+port+"/api/v1/questions/",new QuestionVO(0, "What is 3+2?", "5", "4", "1", "2", "5", "Maths"),QuestionVO.class);
			QuestionVO qu3 = restTemplate.postForObject
	                ("http://localhost:" + port + "/api/v1/questions/", new QuestionVO(0, "What planet is closest to the Sun?", "Earth", "Venus", "Mercury", "Mars", "Mercury", "Science"), QuestionVO.class);
			QuestionVO qu4 = restTemplate.postForObject
	                ("http://localhost:" + port + "/api/v1/questions/", new QuestionVO(0, "Who was the first man to walk on the Moon?", "Buzz Aldrin", "Neil Armstrong", "Yuri Gagarin", "Michael Collins", "Neil Armstrong", "History"), QuestionVO.class);
			QuestionVO qu5 = restTemplate.postForObject
	                ("http://localhost:" + port + "/api/v1/questions/", new QuestionVO(0, "Which country is Paris the capital of?", "Spain", "Italy", "France", "Germany", "France", "Geography"), QuestionVO.class);
			QuestionVO qu6 = restTemplate.postForObject
	                ("http://localhost:" + port + "/api/v1/questions/", new QuestionVO(0, "Who wrote 'Harry Potter'?", "J.R.R. Tolkien", "J.K. Rowling", "George R.R. Martin", "Mark Twain", "J.K. Rowling", "Literature"), QuestionVO.class);

		
		}
		
				
	}

}
