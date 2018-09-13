package com.dlu.task.mgmt.accountservice;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private AccountRepository repository;

    public AccountRestController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getAccounts(){

        return this.repository.findAll();

    }

}
