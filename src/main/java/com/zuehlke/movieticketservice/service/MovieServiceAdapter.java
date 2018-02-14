package com.zuehlke.movieticketservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.zuehlke.movieticketservice.model.Movie;
import com.zuehlke.movieticketservice.model.MovieDetail;

public class MovieServiceAdapter {

	private final MovieServiceApiClient moviesApiClient;

	public MovieServiceAdapter(String url) {
		moviesApiClient = RestClientFactory.createClient(url, MovieServiceApiClient.class);
	}

	public List<Movie> getAll() {
		List<MovieServiceResponse> movieServiceResponse = moviesApiClient.getMovies();

		return movieServiceResponse.stream()
				.map(response -> new Movie(response.getId(), response.getTitle(), response.getPoster()))
				.collect(Collectors.toList());
	}

	public Optional<MovieDetail> getMovieById(long id) {
		return null;
	}
}