package com.akash.springsecurity.repository;

import com.akash.springsecurity.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Akash Bhuiyan, 5/9/24
 **/

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Accounts findByCustomerId(long customerId);

}
