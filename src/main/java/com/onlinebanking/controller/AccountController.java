package com.onlinebanking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.dto.AccountDTO;
import com.onlinebanking.entity.Account;
import com.onlinebanking.service.AccountService;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {
	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) {
		Account createdAccount = accountService.createAccount(accountDTO);
		return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> accounts = accountService.getAllAccounts();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id) {
		Account account = accountService.getAccountById(id);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Account>> searchAccountsByUser(@RequestParam("userName") String userName) {
		System.out.println(userName);
		List<Account> accounts = accountService.searchAccountsByUser(userName);
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id, @RequestBody AccountDTO accountDTO) {
		Account updatedAccount = accountService.updateAccount(id, accountDTO);
		return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
