package com.neshy.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neshy.expenses.entity.Expense;
import com.neshy.expenses.entity.Income;
import com.neshy.expenses.repository.ExpenseRepository;
import com.neshy.expenses.repository.IncomeRepository;

@RestController
public class Register {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    IncomeRepository incomeRepository;
    
    @PostMapping("/expense")
    public ResponseEntity<HttpStatus> registerExpense(@RequestBody Expense expense) {

        HttpStatus code;

        if(expense != null) {
            expenseRepository.create(expense);
            code = HttpStatus.ACCEPTED;
        }
        else {
            code = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(code).build();
    }


    @PostMapping("/income")
    public ResponseEntity<HttpStatus> registerIncome(@RequestBody Income income) {

        HttpStatus code;

        if(income != null) {
            incomeRepository.create(income);
            code = HttpStatus.ACCEPTED;
        }
        else {
            code = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(code).build();
    }
}
