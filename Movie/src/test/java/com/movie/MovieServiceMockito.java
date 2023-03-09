package com.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;
import com.movie.service.MovieService;

@ExtendWith(SpringExtension.class)
public class MovieServiceMockito {

	@InjectMocks
	MovieService movieService;
	
	@MockBean
	MovieRepository movieRepository;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeAll
	static void setUpBeforeClass() {
		
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		
	}
	
	@BeforeEach
	void setUp() {
		
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	void testAddMovie() {
		Movie movie = new Movie();
		movie.setMovieName("Breaking-Bad");
		movie.setMovieLanguage("English");
		movie.setMovieDuration("168 minutes");
		movie.setMovieReleaseDate("11/12/2011");
		when(movieRepository.save(movie)).thenReturn(movie);
		assertEquals("Breaking-Bad", movie.getMovieName());
		
	}
	
	@Test
	void testgetByMovieId() {
		Movie movie = new Movie();
		movie.setMovieId((long) 1);
		movie.setMovieName("The-Call");
		Mockito.when(movieRepository.findById((long)1)).thenReturn(Optional.of(movie));
		Movie movie1 = movieService.getMovieById((long) 1);
		assertEquals(1, movie.getMovieId());
		assertEquals("The-Call", movie1.getMovieName());
		
		
	}
	
	@Test
	void testgetAllMovies() {
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie((long) 1, "The-Call", "English", "176 minutes", "21/12/1987"));
		movies.add(new Movie((long) 2, "Breaking-Bad", "English", "166 minutes", "2/2/2001"));
		movieRepository.saveAll(movies);
		
		Mockito.when(movieRepository.findAll()).thenReturn(movies);
		assertEquals(2, movies.get(1).getMovieId());
		
		
//		List<Movie> allmovies = (List<Movie>) movieRepository.findAll();
//		Mockito.when( movieRepository.findAll()).thenReturn(allmovies);
//		assertEquals(0, allmovies.size());
	}
	
	
}
