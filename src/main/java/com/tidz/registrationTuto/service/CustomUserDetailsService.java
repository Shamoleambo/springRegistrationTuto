package com.tidz.registrationTuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tidz.registrationTuto.entity.User;
import com.tidz.registrationTuto.repository.UserRepository;
import com.tidz.registrationTuto.security.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomUserDetails(user);
	}

}
