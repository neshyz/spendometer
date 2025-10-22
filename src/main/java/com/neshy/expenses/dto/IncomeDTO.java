package com.neshy.expenses.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IncomeDTO {
    private Long id;
    private double amount;
    private String description;
    private Long account;
}
