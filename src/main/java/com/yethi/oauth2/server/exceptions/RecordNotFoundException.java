package com.yethi.oauth2.server.exceptions;

import org.springframework.http.HttpStatus;

public class RecordNotFoundException extends AbstractException{
	private static final long serialVersionUID = 1786725158540207258L;

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}


	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.NOT_FOUND	;
	}
}
