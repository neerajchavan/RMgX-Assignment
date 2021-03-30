package com.assignment.rmgx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResouceAssignedException extends RuntimeException {

	public ResouceAssignedException(String message) {
		super(message);
	}

	
}
