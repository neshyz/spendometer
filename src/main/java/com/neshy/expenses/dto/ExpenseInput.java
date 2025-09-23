package com.neshy.expenses.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExpenseInput {
    private double amount;
    private String description;
}
