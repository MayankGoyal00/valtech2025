package com.valtech.training.quiz.vos;

import java.util.List;

import com.valtech.training.quiz.entities.Quiz;

import jakarta.persistence.ElementCollection;

public record QuizVO(long quizId, String title, List questionId) {
	
	public static QuizVO from(Quiz q) {
		return new QuizVO(q.getQuizId(), q.getTitle(), q.getQuestionId());
	}
	
	public Quiz to() {
		return new Quiz(quizId, title, questionId);
	}

}
