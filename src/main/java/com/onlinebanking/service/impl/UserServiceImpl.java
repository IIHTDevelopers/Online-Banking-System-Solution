package com.onlinebanking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.dto.UserDTO;
import com.onlinebanking.entity.User;
import com.onlinebanking.repo.AccountRepository;
import com.onlinebanking.repo.TransactionRepository;
import com.onlinebanking.repo.UserRepository;
import com.onlinebanking.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public User createUser(UserDTO userDTO) {
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public List<User> searchUsersByName(String name) {
		return null;
	}

	@Override
	public User getUserById(Long id) {
		return null;
	}

	@Override
	public User updateUser(Long id, UserDTO userDTO) {
		return null;
	}

	@Override
	public boolean deleteUser(Long id) {
		return true;
	}
}
