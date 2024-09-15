package com.akash.springsecurity.controller;

import com.akash.springsecurity.entity.AccountTransactions;
import com.akash.springsecurity.entity.Customer;
import com.akash.springsecurity.repository.AccountTransactionsRepository;
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
public class BalanceController {
    private final AccountTransactionsRepository accountTransactionsRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isPresent()) {
            List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                    findByCustomerIdOrderByTransactionDtDesc(optionalCustomer.get().getId());
            if (accountTransactions != null) {
                return accountTransactions;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
