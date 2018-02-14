package com.zuehlke.movieticketservice.model;

import java.util.Objects;

import com.zuehlke.movieticketservice.service.MovieServiceResponse;

public class Movie {
	private final long id;
	private final String title;
	private final String poster;

	public Movie(long id, String title, String poster) {
		this.id = id;
		this.title = title;
		this.poster = poster;
	}

	public static Movie from(MovieServiceResponse response) {
		return new Movie(
				response.getId(),
				response.getTitle(),
				response.getPoster());
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
