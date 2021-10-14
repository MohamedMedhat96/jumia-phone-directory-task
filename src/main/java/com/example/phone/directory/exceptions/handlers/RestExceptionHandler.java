package com.example.phone.directory.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.phone.directory.exceptions.IncorrectInputException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(IncorrectInputException.class)
	public ResponseEntity<String>  handleIncorrectInputException(IncorrectInputException ex, WebRequest request){
		
		return new ResponseEntity<String>(ex.getMessage(), ex.getStatusCode());
	}
}
