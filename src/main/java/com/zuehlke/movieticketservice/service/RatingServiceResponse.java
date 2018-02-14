package com.zuehlke.movieticketservice.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingServiceResponse {
	private String source;
	private String value;

	@JsonCreator
	public RatingServiceResponse(@JsonProperty("Source") String source, @JsonProperty("Value") String value) {
		this.source = source;
		this.value = value;
	}

	public String getSource() {
		return source;
	}

	public String getValue() {
		return value;
	}
}
