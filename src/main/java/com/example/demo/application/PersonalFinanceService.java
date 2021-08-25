package com.example.demo.application;

import com.example.demo.domain.Account;
import com.example.demo.domain.AccountRepository;
import com.example.demo.domain.Customer;
import com.example.demo.domain.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class PersonalFinanceService {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final CustomerRepository customerRepository;

    public Account openAccount(String firstName, String lastName) {
        boolean isCustomer = customerRepository.findCustomerByFirstNameAndLastName(firstName, lastName).isPresent();
        if (isCustomer == true) {
            throw new IllegalArgumentException("Customer already has an account");
        } else {
        Customer newCustomer = new Customer(firstName,lastName);
        customerRepository.save(newCustomer);

        return accountRepository.save(new Account(newCustomer, 0));
        }
    }
    public Account withdraw(long accountId, long customerId, long amount){
        Account account = (Account) accountRepository.findByCustomerAndId(customerId, accountId).orElseThrow(()-> new RuntimeException("Cannot find account"));
        account.withdraw(amount);
        accountRepository.save(account);
        return account;
    }

    public Account deposit(long accountId, long customerId, long amount){
        Account account = (Account) accountRepository.findByCustomerAndId(customerId, accountId).orElseThrow(()-> new RuntimeException("Cannot find account"));
        account.deposit(amount);
        accountRepository.save(account);
        return account;
    }

    public Account findAccount(long customerId, long accountId) {
        return (Account) accountRepository.findByCustomerAndId(customerId, accountId).orElseThrow(() -> new RuntimeException("Could not find account"));
    }




}
