package com.example.phone.directory.exceptions.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.phone.directory.exceptions.IncorrectInputException;

@ControllerAdvice
public class RestExceptionHandler {

	public static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@ExceptionHandler(IncorrectInputException.class)
	public ResponseEntity<String>  handleIncorrectInputException(IncorrectInputException ex, WebRequest request){
		LOGGER.warn(ex.getMessage(), ex);
		return new ResponseEntity<String>(ex.getMessage(), ex.getStatusCode());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex, WebRequest request){
		LOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<String>("An internal system error has occured: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
