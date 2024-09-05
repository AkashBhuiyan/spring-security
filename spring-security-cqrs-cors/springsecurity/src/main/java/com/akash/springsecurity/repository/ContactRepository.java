package com.akash.springsecurity.repository;

import com.akash.springsecurity.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Akash Bhuiyan, 5/9/24
 **/

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {


}
