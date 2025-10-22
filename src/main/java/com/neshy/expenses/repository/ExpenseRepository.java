package com.neshy.expenses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.dto.ExpenseDTO;
import com.neshy.expenses.entity.Expense;

@Repository
public class ExpenseRepository {
    @Autowired
    IExpenseRepository expenseRepository;

    @Autowired
    RegistryRepository registryRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Expense create(ExpenseDTO dto) {

        // crear registry
        registryRepository.insert(Expense.class.getSimpleName());


        // crear una instancia de un income con los parametros dados por el DTO, salvar esta instancia con save()
        Expense income = new Expense(dto.getAmount(), dto.getDescription(), accountRepository.findById(dto.getAccount()));

        return expenseRepository.save(income);
    }










    
}
