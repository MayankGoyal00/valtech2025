package com.valtech.training.streamingservice.vos;

import com.valtech.training.streamingservice.entities.Movie;

public record MovieVO(long id, String name, String genre,String language, long duration) {
	
	public static MovieVO from(Movie m) {
		return new MovieVO(m.getId(), m.getName(), m.getGenre(), m.getLanguage(), m.getDuration());
	}

	public Movie to() {
		return new Movie(name, genre, language, duration);
	}
}
