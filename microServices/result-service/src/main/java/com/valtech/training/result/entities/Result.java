package com.valtech.training.result.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Result {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "res_seq")
	@SequenceGenerator(name = "res_seq", sequenceName = "res_seq", allocationSize = 1)
	private Long id;
	private Long quizId;
	private String name;
	private int score;
	
	public Result() {
	}

	public Result(Long quizId, String name, int score) {
		super();
		this.quizId = quizId;
		this.name = name;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizid(Long quizId) {
		this.quizId = quizId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
