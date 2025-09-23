package com.neshy.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neshy.expenses.entity.Expense;

@Repository
public interface IExpenseRepository extends JpaRepository<Expense, Long> {
    
}
