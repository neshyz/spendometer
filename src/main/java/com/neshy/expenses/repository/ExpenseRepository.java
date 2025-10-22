package com.neshy.expenses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.entity.Expense;

@Repository
public class ExpenseRepository {
    @Autowired
    IExpenseRepository expenseRepository;
    @Autowired
    RegistryRepository registryRepository;

    public Expense create(Expense input) {
        registryRepository.insert(Expense.class.getSimpleName());

        return expenseRepository.save(input);

    }
}
