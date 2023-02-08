package com.niranad.exampleemployeeapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {
	private final AccountAuthProvider accountAuthProvider;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authManagerBuilder.authenticationProvider(accountAuthProvider);
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers(POST, "/api/accounts/**").permitAll();
		http.authorizeRequests()
			.anyRequest()
			.hasAnyRole("USER","ADMIN")
			.and()
			.httpBasic(Customizer.withDefaults())
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}
}
