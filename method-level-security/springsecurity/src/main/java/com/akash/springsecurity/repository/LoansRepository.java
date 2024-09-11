package com.akash.springsecurity.repository;

import com.akash.springsecurity.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Akash Bhuiyan, 5/9/24
 **/

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {

    @PreAuthorize("hasAnyRole('USER')")
    List<Loans> findByCustomerIdOrderByStartDtDesc(long customerId);

}
