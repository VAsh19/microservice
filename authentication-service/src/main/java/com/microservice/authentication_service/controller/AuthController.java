package com.microservice.authentication_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.authentication_service.entity.User;
import com.microservice.authentication_service.model.AuthRequest;
import com.microservice.authentication_service.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public String addNewUser(@RequestBody User user)
	{
		return authService.saveUser(user);
	}
	
	@PostMapping("/token")
	public String getToken(@RequestBody AuthRequest authRequest)
	{
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName() , authRequest.getPassword()));
		if(authentication.isAuthenticated())
		{
			return authService.generateToken(authRequest.getUserName());
		}
		throw new RuntimeException("user is not valid");
		
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam String token)
	{
	     authService.validateToken(token);
	     return "token is valid";
	}
	
}
