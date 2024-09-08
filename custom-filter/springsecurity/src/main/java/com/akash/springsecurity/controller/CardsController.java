package com.akash.springsecurity.controller;

import com.akash.springsecurity.entity.Cards;
import com.akash.springsecurity.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * Akash Bhuiyan, 20/8/24
 **/

@RequiredArgsConstructor
@RestController
public class CardsController {
    private final CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam long id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }
}
