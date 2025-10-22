package com.neshy.expenses.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.dto.IncomeDTO;
import com.neshy.expenses.entity.Income;

@Repository
public class IncomeRepository {
    @Autowired
    private IIncomeRepository incomeRepository;
    
    @Autowired
    private RegistryRepository registryRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Income create(IncomeDTO dto) {

        // crear registry
        registryRepository.insert(Income.class.getSimpleName());


        // crear una instancia de un income con los parametros dados por el DTO, salvar esta instancia con save()
        Income income = new Income(dto.getAmount(), dto.getDescription(), accountRepository.findById(dto.getAccount()));

        return incomeRepository.save(income);
    }
}
