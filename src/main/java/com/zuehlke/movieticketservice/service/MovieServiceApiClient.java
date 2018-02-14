package com.zuehlke.movieticketservice.service;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface MovieServiceApiClient {
	@RequestLine("GET /api/v1/movies")
	List<MovieServiceResponse> getMovies();

	@RequestLine("GET /api/v1/movies/{id}")
	MovieServiceResponse getMovieById(@Param("id") long id);
}