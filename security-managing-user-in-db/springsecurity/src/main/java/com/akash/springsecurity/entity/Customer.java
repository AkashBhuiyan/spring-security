package com.akash.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/***
 * Akash Bhuiyan, 27/8/24
 **/

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String pwd;

    @Column(name = "role")
    private String role;
}
