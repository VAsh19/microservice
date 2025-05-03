package com.microservice.authentication_service.Util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.microservice.authentication_service.entity.User;

public class CustomUserDetail implements UserDetails {

	private String userName;
	private String password;
	
	public CustomUserDetail(User user)
	{
		this.userName = user.getUserName();
		this.password = user.getPassword();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

}
