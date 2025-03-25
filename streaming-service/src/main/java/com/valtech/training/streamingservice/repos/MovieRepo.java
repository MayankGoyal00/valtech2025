package com.valtech.training.streamingservice.repos;

import java.util.List;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.streamingservice.entities.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{
	
	List<WebSeries> findAllByEpisodeCount(int episodeCount);
	List<WebSeries> findAllByEpisodeDuration(long episodeDuration);

}
