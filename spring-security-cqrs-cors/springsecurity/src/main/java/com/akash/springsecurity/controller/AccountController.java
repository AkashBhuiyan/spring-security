package com.akash.springsecurity.controller;

import com.akash.springsecurity.entity.Accounts;
import com.akash.springsecurity.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * Akash Bhuiyan, 20/8/24
 **/

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountsRepository accountsRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam long id) {
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }

}
