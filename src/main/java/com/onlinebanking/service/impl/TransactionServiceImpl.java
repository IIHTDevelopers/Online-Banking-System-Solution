package com.onlinebanking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.dto.TransactionDTO;
import com.onlinebanking.entity.Transaction;
import com.onlinebanking.entity.TransactionType;
import com.onlinebanking.repo.TransactionRepository;
import com.onlinebanking.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction createTransaction(TransactionDTO transactionDTO) {
		return null;
	}

	@Override
	public Transaction getTransactionById(Long id) {
		return null;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return null;
	}

	@Override
	public List<Transaction> searchTransactionsByType(TransactionType type) {
		return null;
	}

	@Override
	public Transaction updateTransaction(Long id, TransactionDTO transactionDTO) {
		return null;
	}

	@Override
	public boolean deleteTransaction(Long id) {
		return true;
	}
}
