package com.akash.springsecurity.repository;

import com.akash.springsecurity.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Akash Bhuiyan, 5/9/24
 **/

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

    List<Cards> findByCustomerId(long customerId);

}
