package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by Miwa Guhrés
 * Date: 2021-04-20
 * Time: 13:44
 * Project: Labo_Bank
 * Copyright: MIT
 */

public interface CustomerRepository extends JpaRepository <Customer, Long>{
    // to id should work I needed to change customerId May be Account is also use id...
    Customer findByCustomerId(Long id);


}
