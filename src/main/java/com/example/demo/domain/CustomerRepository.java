package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Miwa Guhrés
 * Date: 2021-04-20
 * Time: 13:44
 * Project: Labo_Bank
 * Copyright: MIT
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer save(Customer customer);
    Optional<Customer> findCustomerByFirstNameAndLastName(String firstName, String lastName);
}
