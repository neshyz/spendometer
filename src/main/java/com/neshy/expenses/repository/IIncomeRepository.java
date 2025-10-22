package com.neshy.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.entity.Income;

@Repository
public interface IIncomeRepository extends JpaRepository<Income, Long> {
    
}
