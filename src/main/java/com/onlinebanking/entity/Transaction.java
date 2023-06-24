package com.onlinebanking.entity;

import java.math.BigDecimal;

public class Transaction {
	private Long id;

	private User user;

	private BigDecimal amount;

	private TransactionType type;

	public Transaction() {
		super();
	}

	public Transaction(Long id, User user, BigDecimal amount, TransactionType type) {
		super();
		this.id = id;
		this.user = user;
		this.amount = amount;
		this.type = type;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

}
