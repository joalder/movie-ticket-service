package com.zuehlke.movieticketservice.model;

import java.util.ArrayList;
import java.util.List;

import com.zuehlke.movieticketservice.service.MovieServiceResponse;

public class MovieDetail {
	private final int id;
	private final String title;
	private final String poster;
	private final String plot;
	private final int year;
	private final String genre;
	private final List<Rating> ratings;

	public MovieDetail(int id, String title, String poster, String plot, int year, String genre, List<Rating>
			ratings) {
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.plot = plot;
		this.year = year;
		this.genre = genre;
		this.ratings = ratings;
	}

	public static MovieDetail from(MovieServiceResponse response) {
		return new MovieDetail(
				(int) response.getId(),
				response.getTitle(),
				response.getPoster(),
				response.getPlot(),
				response.getYear(),
				response.getGenre(),
				new ArrayList<>());
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getPoster() {
		return poster;
	}

	public String getPlot() {
		return plot;
	}

	public int getYear() {
		return year;
	}

	public String getGenre() {
		return genre;
	}

	public List<Rating> getRatings() {
		return ratings;
	}
}
