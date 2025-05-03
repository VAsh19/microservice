package com.microservice.authentication_service.service;

import com.microservice.authentication_service.entity.User;

public interface AuthService {

	public String saveUser(User user);
	
	public String generateToken(String userName);
	
	public void validateToken(String token);
}
