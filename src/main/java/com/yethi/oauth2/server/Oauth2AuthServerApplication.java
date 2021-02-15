package com.yethi.oauth2.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yethi.oauth2.server.entity.User;
import com.yethi.oauth2.server.service.UserService;

@SpringBootApplication
public class Oauth2AuthServerApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthServerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("Sriram");
		user.setEmail("s.sriram@yethi.in");
		user.setRole("admin");
		userService.createUser(user);
	}

}
