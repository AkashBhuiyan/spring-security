package com.akash.springsecurity.controller;

import com.akash.springsecurity.entity.Cards;
import com.akash.springsecurity.entity.Customer;
import com.akash.springsecurity.repository.CardsRepository;
import com.akash.springsecurity.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/***
 * Akash Bhuiyan, 20/8/24
 **/

@RequiredArgsConstructor
@RestController
public class CardsController {
    private final CardsRepository cardsRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam String email) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isPresent()) {
            List<Cards> cards = cardsRepository.findByCustomerId(optionalCustomer.get().getId());
            if (cards != null) {
                return cards;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
