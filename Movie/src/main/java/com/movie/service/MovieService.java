package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;


@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	public Movie addMovie(Movie movie) {
		Movie addmovie = movieRepository.save(movie);
		return addmovie;
	}
	
	public Movie getMovieById(String name) {
		Movie moviebyid = movieRepository.findById(name).get();
		return moviebyid;
	}
	
	public List<Movie> getAllMovies(){
		
		List<Movie> getallMovies = movieRepository.findAll();
		
		return getallMovies;
		
	}
	
}
