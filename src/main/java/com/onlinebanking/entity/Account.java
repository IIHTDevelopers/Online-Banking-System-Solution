package com.onlinebanking.entity;

import java.math.BigDecimal;

public class Account {
	private Long id;

	private User user;

	private String number;

	private BigDecimal balance;

	private AccountType accountType;

	public Account() {
		super();
	}

	public Account(Long id, User user, String number, BigDecimal balance, AccountType accountType) {
		super();
		this.id = id;
		this.user = user;
		this.number = number;
		this.balance = balance;
		this.accountType = accountType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
