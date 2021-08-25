package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private long balance;//int 32bit long 64bit

    @JoinColumn(name="customerId", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //Many accounts for one customer
    @JsonBackReference// Add to use @JsonManagedReference controller Customer
    private  Customer customer;

    public Account(){
        // For hibernate (Dan)
    }

    public Account(long balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public void withdraw(long amount){
        long newBalance = balance-amount;
        if (newBalance<0)
            throw new IllegalStateException("The customer cannot withdraw money because of 0 blance");
        this.balance=this.balance -amount;
    }

    public void deposit(long amount) {
        this.balance = this.balance + amount;
    }

}