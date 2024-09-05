package com.akash.springsecurity.controller;

import com.akash.springsecurity.entity.AccountTransactions;
import com.akash.springsecurity.repository.AccountTransactionsRepository;
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
public class BalanceController {
    private final AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam long id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
