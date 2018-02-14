package com.zuehlke.movieticketservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zuehlke.movieticketservice.model.Movie;
import com.zuehlke.movieticketservice.model.MovieDetail;
import com.zuehlke.movieticketservice.repository.MovieRepository;

@RestController
@RequestMapping("api/v1")
public class MovieController {

	private MovieRepository movieRepository;

	@Autowired
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@GetMapping("movie")
	public List<Movie> getMovies() {
		return movieRepository.getMovies();
	}

	@GetMapping("movie/{id}")
	public MovieDetail getMovies(@PathVariable int id) {
		return movieRepository.getMovieDetails(id);
	}
}
