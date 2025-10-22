package com.neshy.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

}
