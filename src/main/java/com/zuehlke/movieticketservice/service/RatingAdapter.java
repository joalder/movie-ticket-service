package com.zuehlke.movieticketservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.zuehlke.movieticketservice.model.Rating;

public class RatingAdapter {

	private final RatingServiceApiClient client;

	public RatingAdapter(String url) {
		client = RestClientFactory.createClient(url, RatingServiceApiClient.class);
	}

	public List<Rating> getRatingsById(long id) {
		return client.getRatingById(id).stream()
				.map(response -> new Rating(response.getSource(), response.getValue()))
				.collect(Collectors.toList());
	}
}
