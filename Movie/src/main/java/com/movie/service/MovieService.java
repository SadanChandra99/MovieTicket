package com.movie.service;

import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.Movie;
import com.movie.exception.MovieAlreadyExistsException;
import com.movie.exception.MovieNotFoundException;
import com.movie.repository.MovieRepository;


@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	public Movie addMovie(Movie movie) throws MovieAlreadyExistsException {
		Movie addmovie = movieRepository.save(movie);
		return addmovie;
	}
	
	public Movie getMovieById(Long movieId) throws MovieNotFoundException{
		Movie moviebyid = movieRepository.findById(movieId).get();
		
			return moviebyid;
		
		
	}
	
	public List<Movie> getAllMovies(){
		
		List<Movie> getallMovies = movieRepository.findAll();
		
		return getallMovies;
		
	}
	
}
