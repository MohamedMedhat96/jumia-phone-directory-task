package com.example.phone.directory.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectInputException extends RuntimeException{

	private HttpStatus statusCode;
	
	private String message;
	
	public IncorrectInputException(String message, HttpStatus statusCode) {
			this.message = message;
			this.statusCode = statusCode;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
