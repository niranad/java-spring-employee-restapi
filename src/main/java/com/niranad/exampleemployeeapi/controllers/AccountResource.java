package com.niranad.exampleemployeeapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niranad.exampleemployeeapi.models.Account;
import com.niranad.exampleemployeeapi.services.impls.AccountService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Valid
@RequestMapping(path = "/api/accounts")
public class AccountResource {
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		 Account newAccount = accountService.createAccount(account);
		 return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> getAccounts() {
		return ResponseEntity.ok(accountService.getAccounts());
	}
}
