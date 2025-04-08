package com.valtech.training.result.vos;

import com.valtech.training.result.entities.Result;

public record ResultVO(Long id, Long quizId, String name, int score) {

	public static ResultVO from(Result r) {
		return new ResultVO(r.getId(), r.getQuizId(), r.getName(), r.getScore());
	}
	
	public Result to() {
		return new Result(quizId,name,score);
	}
}
