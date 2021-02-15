package com.yethi.oauth2.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	private String name;
	private String email;
	private String role;
	private Long id;
	
	public UserResponse(String name, String email, Long id) {
		this.id = id;
		this.email = email;
		this.name = name;
	}
}
