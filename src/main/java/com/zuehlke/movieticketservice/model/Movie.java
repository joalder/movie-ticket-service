package com.zuehlke.movieticketservice.model;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Movie movie = (Movie) o;
		return id == movie.id &&
				Objects.equals(title, movie.title) &&
				Objects.equals(poster, movie.poster);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, title, poster);
	}
}
