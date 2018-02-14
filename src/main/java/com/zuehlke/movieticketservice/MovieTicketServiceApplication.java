package com.zuehlke.movieticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zuehlke.movieticketservice.service.MovieServiceAdapter;
import com.zuehlke.movieticketservice.service.RatingAdapter;

@SpringBootApplication
public class MovieTicketServiceApplication {

	@Bean
	public MovieServiceAdapter createMovieServiceAdapter() {
		return new MovieServiceAdapter("https://movie-service.herokuapp.com/");
	}

	@Bean
	public RatingAdapter createMovieRatingServiceAdapter() {
		return new RatingAdapter("https://movie-rating-service.herokuapp.com");
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketServiceApplication.class, args);
	}
}

