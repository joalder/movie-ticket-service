package com.zuehlke.movieticketservice.model;

public class Movie {
	private long id;
	private String title;
	private String poster;

	public Movie(long id, String title, String poster) {
		this.id = id;
		this.title = title;
		this.poster = poster;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getPoster() {
		return poster;
	}

	@Override
	public String toString() {
		return "Movie{" +
				"id=" + id +
				", title='" + title + '\'' +
				", poster='" + poster + '\'' +
				'}';
	}
}
