package com.yethi.oauth2.server.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yethi.oauth2.server.config.LoggedInUser;
import com.yethi.oauth2.server.model.UserResponse;
import com.yethi.oauth2.server.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/api/users")
	public List<UserResponse> getUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/api/my/profile")
	public UserResponse getMyProfile(Authentication authentication) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("Auth principal is --> {}", auth.getPrincipal());
		return ((LoggedInUser) authentication.getPrincipal()).getUser();
	}
}
