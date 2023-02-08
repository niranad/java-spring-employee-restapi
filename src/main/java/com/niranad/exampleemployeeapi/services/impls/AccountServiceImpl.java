package com.niranad.exampleemployeeapi.services.impls;

import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.niranad.exampleemployeeapi.models.Account;
import com.niranad.exampleemployeeapi.models.Role;
import com.niranad.exampleemployeeapi.repositories.AccountRepo;
import com.niranad.exampleemployeeapi.repositories.RoleRepo;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	private final AccountRepo accountRepo;
	private final RoleRepo roleRepo;
	private final PasswordEncoder encoder;
	
	@Override
	public Account createAccount(Account account) {
		account.setPassword(encoder.encode(account.getPassword()));
		Role role = roleRepo.findByName("ROLE_USER");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		account.setRoles(roles);
		return accountRepo.save(account);
	}

	@Override
	public Account findByUsername(String username) {
		return accountRepo.findByUsername(username);
	}

	@Override
	public List<Account> getAccounts() {
		return accountRepo.findAll();
	}

}
