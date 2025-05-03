package com.microservice.authentication_service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.authentication_service.Util.JwtUtil;
import com.microservice.authentication_service.entity.User;
import com.microservice.authentication_service.repository.UserRepository;
import com.microservice.authentication_service.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public String saveUser(User user)
	{
		user.setPassword(passwordEncoder.encode( user.getPassword()));
		userRepository.save(user);
		return "user added to the system";
	}
	
	public String generateToken(String userName)
	{
		return jwtUtil.generateToken(userName);
	}
	
	public void validateToken(String token)
	{
		jwtUtil.validateToken(token);
	}
}
