package com.zuehlke.movieticketservice.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zuehlke.movieticketservice.model.Movie;
import com.zuehlke.movieticketservice.model.MovieDetail;

public class MovieRepository {

	private List<Movie> movies = new ArrayList<>();
	private Map<Integer, MovieDetail> movieDetails = new HashMap<>();

	public MovieRepository() {
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void addMovie(Movie movie) {
		this.movies.add(movie);
	}

	public MovieDetail getMovieDetails(int id) {
		return this.movieDetails.get(id);
	}

	public void addMovieDetails(MovieDetail movieDetail) {
		this.movieDetails.put(movieDetail.getId(), movieDetail);
	}

}
