package com.account.jpaInheritance.controller.resource;

import com.account.jpaInheritance.model.entities.Person;
import com.account.jpaInheritance.model.entities.accounts.Accounts;
import com.account.jpaInheritance.model.service.AccountService;
import com.account.jpaInheritance.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Accounts>> findAll()
    {
        List<Accounts> personList = accountService.findAll();
        return ResponseEntity.ok().body(personList);
    }
}
