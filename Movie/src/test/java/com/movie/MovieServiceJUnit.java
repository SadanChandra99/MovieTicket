package com.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;
import com.movie.service.MovieService;

@SpringBootTest
public class MovieServiceJUnit {

	@Autowired
	private MovieService movieService;

	@Autowired
	private MovieRepository movieRepository;

	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("Before All");
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		System.out.println("After All");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Before Each");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("After Each");
	}
	
	@Test
	void addMovieTest() {
	 Movie movie= new Movie();
	 movie.setMovieName("The-Call");
	 movie.setMovieLanguage("English");
	 movie.setMovieDuration("169 minutes");
	 movie.setMovieReleaseDate("19/07/2009");
	
	 Movie newMovie = movieService.addMovie(movie);
	 assertEquals("The-Call",newMovie.getMovieName());
	 assertEquals("English",newMovie.getMovieLanguage());
	 assertEquals("169 minutes", newMovie.getMovieDuration());
	 assertEquals("19/07/2009", newMovie.getMovieReleaseDate());
	}
	
	@Test
	 void getAllMovies() {
	 List<Movie> allmovies = new ArrayList<Movie>();
	 allmovies.add(new Movie((long) 1, "Breaking-Bad", "English", "132 minutes", "12/12/2002"));
	 allmovies.add(new Movie((long) 2, "Seeta-Ramam", "Telugu", "189 minutes", "11/11/2012"));
	 allmovies.add(new Movie((long) 3, "I", "Tamil", "201 minutes", "1/12/1999"));
	 movieRepository.saveAll(allmovies);
	 List<Movie> movies = (List<Movie>) movieRepository.findAll();
	 assertEquals(3,allmovies.size());
	 Movie movie=movies.get(2);
	 assertEquals("I",movie.getMovieName());
	}
	
	@Test
	void getMovieById() {
		List<Movie> allmovies = new ArrayList<Movie>();
		 allmovies.add(new Movie((long) 1, "Breaking-Bad", "English", "132 minutes", "12/12/2002"));
		 allmovies.add(new Movie((long) 2, "Seeta-Ramam", "Telugu", "189 minutes", "11/11/2012"));
		 movieRepository.saveAll(allmovies);
		 
		 assertEquals("Seeta-Ramam", allmovies.get(1).getMovieName());
		 assertEquals("Telugu", allmovies.get(1).getMovieLanguage());
		 assertEquals("189 minutes", allmovies.get(1).getMovieDuration());
	}
	
}
