package com.onlinebanking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.dto.AccountDTO;
import com.onlinebanking.entity.Account;
import com.onlinebanking.repo.AccountRepository;
import com.onlinebanking.repo.UserRepository;
import com.onlinebanking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Account createAccount(AccountDTO accountDTO) {
		return null;
	}

	@Override
	public Account getAccountById(Long id) {
		return null;
	}

	@Override
	public Account getAccountByNumber(String number) {
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		return null;
	}

	@Override
	public List<Account> searchAccountsByUser(String userName) {
		return null;
	}

	@Override
	public Account updateAccount(Long id, AccountDTO account) {
		return null;
	}

	@Override
	public boolean deleteAccount(Long id) {
		return true;
	}
}
