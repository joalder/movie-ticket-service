package com.zuehlke.movieticketservice.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zuehlke.movieticketservice.domain.Movie;
import com.zuehlke.movieticketservice.domain.MovieDetails;

public class MovieRepository {

	private List<Movie> movies = new ArrayList<>();
	private Map<Integer, MovieDetails> movieDetails = new HashMap<>();

	public MovieRepository() {
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void addMovie(Movie movie) {
		this.movies.add(movie);
	}

	public MovieDetails getMovieDetails(int id) {
		return this.movieDetails.get(id);
	}

	public void addMovieDetails(MovieDetails movieDetails) {
		this.movieDetails.put(movieDetails.getId(), movieDetails);
	}

}
