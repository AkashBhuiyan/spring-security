package com.akash.authserver.repository;

import com.akash.authserver.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/***
 * Akash Bhuiyan, 17/9/24
 **/

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

}
