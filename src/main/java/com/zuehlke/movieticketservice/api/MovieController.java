package com.zuehlke.movieticketservice.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zuehlke.movieticketservice.domain.Movie;
import com.zuehlke.movieticketservice.domain.MovieDetails;
import com.zuehlke.movieticketservice.domain.Rating;

@RestController
@RequestMapping("api/v1")
public class MovieController {

	@GetMapping("movie")
	public List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<>();

		movies.add(new Movie(1, "Batman Begins",
				"https://images-na.ssl-images-amazon"
						+ ".com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg"));
		movies.add(new Movie(2, "Ted",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1OTU0ODcxMV5BMl5BanBnXkFtZTcwOTMxNTUwOA@@"
						+ "._V1_SX300.jpg"));
		movies.add(new Movie(3, "Inception",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@"
						+ "._V1_SX300.jpg"));

		return movies;
	}

	@GetMapping("movie/{id}")
	public MovieDetails getMovies(@PathVariable long id) {
		List<Rating> ratings = new ArrayList<>();

		ratings.add(new Rating("Internet Movie Database", "8.3/10"));
		ratings.add(new Rating("Rotten Tomatoes", "84%"));

		return new MovieDetails(1, "Batman Begins",
				"https://images-na.ssl-images-amazon"
						+ ".com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg",
				"After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from the "
						+ "corruption that Scarecrow and the League of Shadows have cast upon it.",
				2005,
				"Action",
				ratings);
	}
}
