package com.zuehlke.movieticketservice.model;

import java.util.List;

public class MovieDetails {
	private int id;
	private String title;
	private String poster;
	private String plot;
	private int year;
	private String genre;
	private List<Rating> ratings;

	public MovieDetails(int id, String title, String poster, String plot, int year, String genre, List<Rating>
			ratings) {
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.plot = plot;
		this.year = year;
		this.genre = genre;
		this.ratings = ratings;
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
