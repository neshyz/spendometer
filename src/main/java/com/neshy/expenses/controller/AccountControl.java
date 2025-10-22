package com.neshy.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neshy.expenses.dto.AccountDTO;
import com.neshy.expenses.repository.AccountRepository;

@RestController
public class AccountControl {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/newaccount")
    public ResponseEntity<HttpStatus> createAccount(@RequestBody AccountDTO account) {

        HttpStatus code;

        if(account != null) {
            accountRepository.insertFromDto(account);
            code = HttpStatus.ACCEPTED;
        }
        else {
            code = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(code).build();
    }
}
