package com.neshy.expenses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.entity.Registry;

@Repository
public class RegistryRepository {

    @Autowired
    private IRegistryRepository registryRepository;

    public void insert(String type) {

        registryRepository.save(
            new Registry(type)
        );
        
    }
}
