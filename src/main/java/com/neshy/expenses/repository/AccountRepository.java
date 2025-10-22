package com.neshy.expenses.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.dto.AccountDTO;
import com.neshy.expenses.entity.Account;

@Repository
public class AccountRepository {

    @Autowired
    private IAccountRepository accountRepository;

    public Account insertFromDto(AccountDTO dto) {

        Optional<Account> account = accountRepository.findById(dto.getId());
        

        return accountRepository.save(account.get());
    }

    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }
}
