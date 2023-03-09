package com.movie.ticket.exception;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> HandleInvalidArgument(MethodArgumentNotValidException ex){
		Map<String, String> errorMap = new HashMap<>();	
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	@ExceptionHandler(value = TicketNotFoundException.class)
	public ResponseEntity<String> ticketNotFound(TicketNotFoundException ex) {
		return new ResponseEntity<>("Ticket is Not Found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TicketAlreadyExistsException.class)
	public ResponseEntity<String> ticketAlreadyExists(TicketAlreadyExistsException ex) {
		return new ResponseEntity<>("Ticket AlreadyExists", HttpStatus.ALREADY_REPORTED);
	}

	@ExceptionHandler(value = TicketCannotUpdateException.class)
	public ResponseEntity<String> TicketCannotUpdate(TicketCannotUpdateException ex) {
		return new ResponseEntity<>("Ticket Cannot Update", HttpStatus.NOT_FOUND);
	}

}
