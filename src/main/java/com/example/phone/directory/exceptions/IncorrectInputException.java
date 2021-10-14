package com.example.phone.directory.exceptions;

public class IncorrectInputException extends RuntimeException{

	String message;
	
	public IncorrectInputException(String message) {
			this.message = message;
	}
}
