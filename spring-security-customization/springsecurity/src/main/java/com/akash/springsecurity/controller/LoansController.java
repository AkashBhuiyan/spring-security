package com.akash.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Akash Bhuiyan, 20/8/24
 **/

@RestController
public class LoansController {
    @GetMapping("/myLoans")
    public  String getLoansDetails () {
        return "Here are the loans details from the DB";
    }
}
