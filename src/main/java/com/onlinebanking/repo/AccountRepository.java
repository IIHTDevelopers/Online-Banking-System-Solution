package com.onlinebanking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebanking.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
