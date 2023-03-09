package com.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = CustomerNotFoundException.class )
	public ResponseEntity<String> customerNotFoundException(CustomerNotFoundException ex){
		return new ResponseEntity<String>("Customer Does not Exist", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CustomerAlreadyExistsException.class)
	public ResponseEntity<String> customerAlreadyExistsException(CustomerAlreadyExistsException ce){
		return new ResponseEntity<String>("Customer Already Exists", HttpStatus.ALREADY_REPORTED);
	}

}
