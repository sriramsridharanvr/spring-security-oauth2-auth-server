package com.yethi.oauth2.server;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Thanks to Bruno Cleite
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	
	private HttpStatus status;
	private String message;
	
	
}

