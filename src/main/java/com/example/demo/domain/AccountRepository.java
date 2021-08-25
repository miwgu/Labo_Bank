package com.example.demo.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository extends CrudRepository <Account, Long>{

    Account save(Account account);

   Optional<Account> findByCustomerAndId(long customerId, long accountId);
}
