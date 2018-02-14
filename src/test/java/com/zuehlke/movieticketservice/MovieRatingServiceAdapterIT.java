package com.zuehlke.movieticketservice;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;

import com.zuehlke.movieticketservice.model.Rating;
import com.zuehlke.movieticketservice.service.MovieRatingAdapter;

public class MovieRatingServiceAdapterIT {

	static {
		System.setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", "5000");
	}

	@Test
	public void getRatingsById() {
		MovieRatingAdapter ratingAdapter = new MovieRatingAdapter("https://movie-rating-service.herokuapp.com");

		List<Rating> ratings = ratingAdapter.getRatingsById(1);

		assertThat(ratings, hasSize(3));
		assertThat(ratings, hasItem(new Rating("Internet Movie Database", "8.3/10")));
	}

}