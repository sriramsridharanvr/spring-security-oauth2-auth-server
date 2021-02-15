package com.yethi.oauth2.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yethi.oauth2.server.config.LoggedInUser;
import com.yethi.oauth2.server.entity.User;
import com.yethi.oauth2.server.exceptions.RecordNotFoundException;
import com.yethi.oauth2.server.model.UserResponse;
import com.yethi.oauth2.server.repo.UserRepository;
import com.yethi.oauth2.server.utils.ObjectMapperUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UserResponse> getAllUsers() {
		return ObjectMapperUtils.mapAll(userRepository.findAll(), UserResponse.class);
	}
	
	public User getUserByEmail(String email) {
		Optional<User> user = userRepository.findOneByEmail(email);
		if(user.isPresent()) {
			return user.get();
		}else {
			log.error("Error --> User with email {} does not exist", email);
			throw new RecordNotFoundException("User not found");
		}
	}
	
	public void createUser(User user) {
		user.setPassword(passwordEncoder.encode("Welcome@123"));
		userRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUserByEmail(username);
		return new LoggedInUser(user);
	}
}
