package com.neshy.expenses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.entity.Income;

@Repository
public class IncomeRepository {
    @Autowired
    private IIncomeRepository incomeRepository;
    
    @Autowired
    private RegistryRepository registryRepository;

    
    public Income create(Income income) {
        registryRepository.insert(Income.class.getSimpleName());

        return incomeRepository.save(income);
    }
}
