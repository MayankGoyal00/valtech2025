package com.valtech.training.jawsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaws.HelloWorld;
import com.valtech.training.jaws.Movie;
import com.valtech.training.jaws.webservices.MovieServiceWS;

@SpringBootTest
class JawsclientApplicationTests {

	@Autowired
	private HelloWorld helloworld;
	

	@Autowired
	private MovieServiceWS movieServiceWS;
	
	@Test
	void contextLoads() {
		System.out.println(helloworld.hello("Valtech"));
		movieServiceWS.createMovie(new Movie("Naryagan","action","tamil",List.of("kamal","shee")));
		movieServiceWS.createMovie(new Movie("Ali","action","tamil",List.of("kamal","shee")));
		System.out.println(movieServiceWS.getAllMovies());

		
	}
}
