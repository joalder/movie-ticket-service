package com.zuehlke.movieticketservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.zuehlke.movieticketservice.model.Rating;

public class MovieRatingAdapter {

	private final MovieRatingServiceApiClient client;

	public MovieRatingAdapter(String url) {
		client = RestClientFactory.createClient(url, MovieRatingServiceApiClient.class);
	}

	public List<Rating> getRatingsById(long id) {
		return client.getRatingById(id).stream()
				.map(response -> new Rating(response.getSource(), response.getValue()))
				.collect(Collectors.toList());
	}
}
