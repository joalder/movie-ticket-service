package com.zuehlke.movieticketservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zuehlke.movieticketservice.service.MovieServiceAdapter;
import com.zuehlke.movieticketservice.service.RatingAdapter;

@SpringBootApplication
public class MovieTicketServiceApplication {

	@Bean
	public MovieServiceAdapter createMovieServiceAdapter(@Value("${endpoint.movie-service}") String url) {
		return new MovieServiceAdapter(url);
	}

	@Bean
	public RatingAdapter createMovieRatingServiceAdapter(@Value("${endpoint.movie-rating-service}") String url) {
		return new RatingAdapter(url);
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketServiceApplication.class, args);
	}
}
