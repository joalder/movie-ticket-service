package com.zuehlke.movieticketservice.service;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface MovieRatingServiceApiClient {
	@RequestLine("GET /api/v1/ratings/{id}")
	List<RatingServiceResponse> getRatingById(@Param("id") long id);
}