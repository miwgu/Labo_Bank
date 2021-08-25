package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Miwa Guhrés
 * Date: 2021-04-20
 * Time: 13:44
 * Project: Labo_Bank
 * Copyright: MIT
 */

@Getter
@Setter
@Entity
public class Account {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name = "balance")
    private long balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer", referencedColumnName = "id")
    private Customer customer;

    public Account(Customer customer, long balance){
        this.customer = customer;
        this.balance = balance;
    }

    public Account() {

    }

    public void withdraw(long amount) {
        long newBalance = balance - amount;
        if (newBalance < 0) throw new IllegalStateException("Balance cannot be less than 0");
        this.balance = this.balance - amount;
    }

    public void deposit(long amount) {
        this.balance = this.balance + amount;
    }
}
