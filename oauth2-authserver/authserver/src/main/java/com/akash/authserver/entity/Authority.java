package com.akash.authserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/***
 * Akash Bhuiyan, 17/9/24
 **/

@Entity
@Getter
@Setter
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
