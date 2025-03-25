package com.valtech.training.question.vos;

import com.valtech.training.question.entities.Question;

public record QuestionVO(long id, String option1, String option2, String option3, String option4, String correctAnswer, String title, String topic) {

	public static QuestionVO from(Question q) {
		return new QuestionVO(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getCorrectAnswer(),q.getTitle(),q.getTopic());
	}
	
	public Question to() {
		return new Question(option1, option2, option3, option4, correctAnswer, title,topic);
	}
}
