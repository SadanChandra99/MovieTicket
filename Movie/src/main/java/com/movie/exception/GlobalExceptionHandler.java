package com.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = MovieNotFoundException.class)
	public ResponseEntity<String> movieNotFoundException(MovieNotFoundException ex){
		return new ResponseEntity<>("Movie Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = MovieAlreadyExistsException.class)
	public ResponseEntity<String> movieAlreadyExistsException(MovieAlreadyExistsException ex){
		return new ResponseEntity<>("Movie Already Exists", HttpStatus.ALREADY_REPORTED);
	}

}
