package com.yethi.oauth2.server.exceptions;

import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException{
	private static final long serialVersionUID = -1834308284631743125L;
	
	
	protected AbstractException(String message) {
		super(message);
	}
	
	protected AbstractException(String message, Throwable cause) {
		super(message, cause);
	}

	public abstract HttpStatus getHttpStatus();
	
	
}
