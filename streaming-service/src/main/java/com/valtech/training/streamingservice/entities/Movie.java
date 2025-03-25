package com.valtech.training.streamingservice.entities;

import jakarta.persistence.Entity;

@Entity
public class Movie extends Content{
	
	private long duration;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public Movie(String name, String genre, String language, long duration) {
		super(name, genre, language);
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	
	
	
	
}
