package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.Movie;
import com.movie.service.MovieService;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
		Movie addmovie = movieService.addMovie(movie);
		return ResponseEntity.ok(addmovie);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Movie> getbyid(@PathVariable("id") Long id){
		Movie movie = movieService.getMovieById(id);
		return ResponseEntity.ok(movie);
	}
	
	@GetMapping(value = "/get")
	public ResponseEntity<List<Movie>> getallmovies(){
		List<Movie> allMovies = movieService.getAllMovies();
		return ResponseEntity.ok(allMovies);
	}

}
