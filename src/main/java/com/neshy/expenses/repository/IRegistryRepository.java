package com.neshy.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.entity.Registry;

@Repository
public interface IRegistryRepository extends JpaRepository<Registry, Long> {
    
}
