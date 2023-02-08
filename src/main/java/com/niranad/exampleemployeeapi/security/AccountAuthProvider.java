package com.niranad.exampleemployeeapi.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.niranad.exampleemployeeapi.services.impls.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountAuthProvider extends AbstractUserDetailsAuthenticationProvider {
	private final UserDetailsServiceImpl userDetailsService;
	private final PasswordEncoder encoder;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authToken) throws AuthenticationException {
		if (authToken.getCredentials() == null || userDetails.getPassword() == null) {
			throw new BadCredentialsException("Credentials may not be null");
		}
		if (!encoder.matches(authToken.getCredentials().toString(), userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid credentials");
		}
	}
	
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authToken) throws AuthenticationException {
		return userDetailsService.loadUserByUsername(username);
	}

}
