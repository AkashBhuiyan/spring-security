package com.akash.springsecurity.controller;

import com.akash.springsecurity.entity.Loans;
import com.akash.springsecurity.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * Akash Bhuiyan, 20/8/24
 **/

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoansRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam long id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null) {
            return loans;
        } else {
            return null;
        }
    }

}
