package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Miwa Guhrés
 * Date: 2021-04-20
 * Time: 13:44
 * Project: Labo_Bank
 * Copyright: MIT
 */

public interface CustomerRepository extends JpaRepository <Customer, Long>{
}
