package com.niranad.exampleemployeeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niranad.exampleemployeeapi.models.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	Account findByUsername(String username);
}
