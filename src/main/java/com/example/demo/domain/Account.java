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
    private int balance;

    @JoinColumn(name="customerId", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //Many accounts for one customer
    @JsonBackReference// Add to use @JsonManagedReference controller Customer
    private  Customer customer;



}
