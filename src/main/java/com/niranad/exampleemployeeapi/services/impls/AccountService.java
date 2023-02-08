package com.niranad.exampleemployeeapi.services.impls;

import java.util.List;

import com.niranad.exampleemployeeapi.models.Account;


public interface AccountService {
	Account createAccount(Account account);
	Account findByUsername(String username);
	List<Account> getAccounts();
}
