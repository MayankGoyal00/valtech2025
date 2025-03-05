package com.valtech.training.first.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.first.entites.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

	List<Question> findAllByTopic(String topic);
	
	List<Question> findAllByTopic(String topic,Pageable p);

	long countByTopicAndQuestionTextContaining(String topic, String keyword);

	long countByTopic(String topic);

	long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyword);
}





//spring boot part of JPA is intelligent(for query) 