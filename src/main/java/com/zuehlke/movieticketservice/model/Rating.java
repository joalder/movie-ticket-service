package com.zuehlke.movieticketservice.model;

import java.util.Objects;

import com.zuehlke.movieticketservice.service.RatingServiceResponse;

public class Rating {
	private final String source;
	private final String value;

	public Rating(String source, String value) {
		this.source = source;
		this.value = value;
	}

	public static Rating from(RatingServiceResponse response){
		return new Rating(response.getSource(), response.getValue());
	}

	public String getSource() {
		return source;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Rating rating = (Rating) o;
		return Objects.equals(source, rating.source) &&
				Objects.equals(value, rating.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(source, value);
	}
}
