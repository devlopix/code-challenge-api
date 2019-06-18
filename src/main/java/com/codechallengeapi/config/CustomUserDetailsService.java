package com.codechallengeapi.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codechallengeapi.model.CustomUserDetails;
import com.codechallengeapi.model.User;
import com.codechallengeapi.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByEmail(email);

		user.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

		return user.map(CustomUserDetails::new).get();
	}

}
