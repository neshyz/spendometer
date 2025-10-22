package com.neshy.expenses.entity;

import java.time.LocalDateTime;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "expenses")
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String description;

    @Column(columnDefinition= "timestamp default current_timestamp()")
    @Transient
    private LocalDateTime date;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;




    public Expense(double amount, String description, Optional<Account> account) {
        this.amount = amount;
        this.description = description;
        this.account = account.get();
    }
}
