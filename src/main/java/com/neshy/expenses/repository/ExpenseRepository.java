package com.neshy.expenses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.entity.Expense;

@Repository
public class ExpenseRepository {
    @Autowired
    IExpenseRepository expenseRepository;

    public Expense create(Expense input) {

        return expenseRepository.save(input);

    }
}
