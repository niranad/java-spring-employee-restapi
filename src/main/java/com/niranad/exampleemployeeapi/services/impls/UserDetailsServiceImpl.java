package com.niranad.exampleemployeeapi.services.impls;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.niranad.exampleemployeeapi.models.Account;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	private final AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountService.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}
		if (account.getRole() == null || account.getRoles().isEmpty()) {
			throw new RuntimeException("user has no roles");
		}
		Collection<GrantedAuthority> authorities = account.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()).collect(toList()));
		return new User(account.getUsername(), account.isEnabled(), !account.isExpired(),
				!account.isCredentialsExpired(), !account.isLocked(), authorities);
	}
}
