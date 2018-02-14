package com.zuehlke.movieticketservice.api;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerComponentTest {

	@LocalServerPort
	private int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	public void getMovies() {
		when()
				.get("/api/v1/movie")
		.then()
				.statusCode(200)
				.body("[0].id", equalTo(1))
				.body("[1].id", equalTo(2))
				.body("[2].id", equalTo(3))

				.body("[0].title", equalTo("Batman Begins"))
				.body("[1].title", equalTo("Ted"))
				.body("[2].title", equalTo("Inception"))
		;
	}

	@Test
	public void getMovieById() {
		when()
				.get("/api/v1/movie/1")
		.then()
				.statusCode(200)
				.body("id", equalTo(1))
				.body("title", equalTo("Batman Begins"))
				.body("ratings", hasSize(2))
				.body("ratings[1].source", equalTo("Rotten Tomatoes"))
				.body("ratings[1].value", equalTo("84%"))
		;
	}

}
