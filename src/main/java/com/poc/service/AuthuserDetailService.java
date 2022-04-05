package com.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poc.model.Authuser;
import com.poc.repository.AuthuserRepository;

@Service
public class AuthuserDetailService implements UserDetailsService{

	@Autowired
	private AuthuserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Authuser user = userRepository.findByUsername(username);
		AuthuserDetails userDetails = new AuthuserDetails();
		
		if(user != null) {
			userDetails.setUser(user);
		}
		else {
			throw new UsernameNotFoundException("username : "+username+" not found");
		}
		
		return userDetails;
		
	}

}
