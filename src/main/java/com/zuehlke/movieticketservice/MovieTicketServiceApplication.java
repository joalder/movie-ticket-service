package com.zuehlke.movieticketservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zuehlke.movieticketservice.model.Movie;
import com.zuehlke.movieticketservice.model.MovieDetail;
import com.zuehlke.movieticketservice.model.Rating;
import com.zuehlke.movieticketservice.repository.MovieRepository;
import com.zuehlke.movieticketservice.service.MovieServiceAdapter;

@SpringBootApplication
public class MovieTicketServiceApplication {

	@Bean
	public MovieRepository createMovieRepository() {
		MovieRepository movieRepository = new MovieRepository();

		loadMovieDetails(movieRepository);
		loadMovies(movieRepository);

		return movieRepository;
	}

	@Bean
	public MovieServiceAdapter createMovieServiceAdapter() {
		return new MovieServiceAdapter("https://movie-service.herokuapp.com/");
	}


	private void loadMovies(MovieRepository movieRepository) {
		movieRepository.addMovie(new Movie(1, "Batman Begins",
				"https://images-na.ssl-images-amazon"
						+ ".com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg"));
		movieRepository.addMovie(new Movie(2, "Ted",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1OTU0ODcxMV5BMl5BanBnXkFtZTcwOTMxNTUwOA@@"
						+ "._V1_SX300.jpg"));
		movieRepository.addMovie(new Movie(3, "Inception",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@"
						+ "._V1_SX300.jpg"));
	}

	private void loadMovieDetails(MovieRepository movieRepository) {
		List<Rating> ratings = new ArrayList<>();

		ratings.add(new Rating("Internet Movie Database", "8.3/10"));
		ratings.add(new Rating("Rotten Tomatoes", "84%"));

		MovieDetail movieDetail = new MovieDetail(1, "Batman Begins",
				"https://images-na.ssl-images-amazon"
						+ ".com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg",
				"After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from the "
						+ "corruption that Scarecrow and the League of Shadows have cast upon it.",
				2005,
				"Action",
				ratings);

		movieRepository.addMovieDetails(movieDetail);
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketServiceApplication.class, args);
	}
}

