package com.example.demo.presentation;

import com.example.demo.domain.Account;
import com.example.demo.domain.AccountRepository;
import com.example.demo.domain.Customer;
import com.example.demo.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Miwa Guhrés
 * Date: 2021-04-20
 * Time: 13:44
 * Project: Labo_Bank
 * Copyright: MIT
 */
@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    public AccountRepository accountRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @GetMapping("/all")
    @ResponseBody
    public  Iterable<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    @PostMapping("/addwithCustomer")
    @ResponseBody
    public String addAccount(@RequestParam Long balance, @RequestParam Long customerId){

        Customer existingCustomer = customerRepository.findByCustomerId(customerId);
        Account a= new Account(balance,existingCustomer);
        accountRepository.save(a);
        return "CustomerId:" + String.valueOf(customerId) + " was connected to an account";
    }

}
