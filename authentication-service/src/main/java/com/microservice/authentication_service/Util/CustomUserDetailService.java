package com.microservice.authentication_service.Util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.microservice.authentication_service.entity.User;
import com.microservice.authentication_service.repository.UserRepository;

public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> credeintal =  userRepository.findByUserName(username);
		
		return credeintal.map(CustomUserDetail::new).orElseThrow(() -> new UsernameNotFoundException("User not found with username : "+ username));
	}

}
