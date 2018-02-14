package com.zuehlke.movieticketservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zuehlke.movieticketservice.model.Movie;
import com.zuehlke.movieticketservice.model.MovieDetail;
import com.zuehlke.movieticketservice.model.Rating;
import com.zuehlke.movieticketservice.service.MovieRatingAdapter;
import com.zuehlke.movieticketservice.service.MovieServiceAdapter;

@RestController
@RequestMapping("api/v1")
public class MovieController {

	private MovieServiceAdapter movieServiceAdapter;
	private MovieRatingAdapter movieRatingAdapter;

	@Autowired
	public MovieController(MovieServiceAdapter movieServiceAdapter, MovieRatingAdapter movieRatingAdapter) {
		this.movieServiceAdapter = movieServiceAdapter;
		this.movieRatingAdapter = movieRatingAdapter;
	}

	@GetMapping("movie")
	public List<Movie> getMovies() {
		return movieServiceAdapter.getAll();
	}

	@GetMapping("movie/{id}")
	public MovieDetail getMovies(@PathVariable int id) {
		MovieDetail movieDetail = movieServiceAdapter.getMovieById(id)
				.orElseThrow(ResourceNotFound::new);

		List<Rating> ratings = movieRatingAdapter.getRatingsById(id);
		movieDetail.getRatings().addAll(ratings);

		return movieDetail;
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	private class ResourceNotFound extends RuntimeException {
	}
}
