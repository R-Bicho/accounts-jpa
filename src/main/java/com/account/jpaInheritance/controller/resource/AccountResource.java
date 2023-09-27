package com.account.jpaInheritance.controller.resource;

import com.account.jpaInheritance.model.entities.Person;
import com.account.jpaInheritance.model.entities.accounts.Accounts;
import com.account.jpaInheritance.model.service.AccountService;
import com.account.jpaInheritance.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Accounts>> findById(@PathVariable Long id)
    {
        Optional<Accounts> account = accountService.findById(id);
        return ResponseEntity.ok().body(account);
    }
}
