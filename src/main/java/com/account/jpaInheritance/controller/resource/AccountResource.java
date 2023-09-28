package com.account.jpaInheritance.controller.resource;

import com.account.jpaInheritance.model.entities.accounts.Accounts;
import com.account.jpaInheritance.model.service.AccountService;
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

    @PostMapping
    public ResponseEntity<Accounts> insert(@RequestBody Accounts obj)
    {
        Accounts newAccount = accountService.insert(obj);
        return ResponseEntity.ok().body(newAccount);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id)
    {
        accountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Accounts> update(@PathVariable Long id, @RequestBody Accounts obj)
    {
        Accounts accounts = accountService.update(id, obj);
        return ResponseEntity.ok().body(accounts);
    }

    @PutMapping(value = "/deposit/{id}/{amount}")
    public ResponseEntity<Accounts> deposit(@PathVariable Long id,
                                            @PathVariable Double amount)
    {
        Accounts ac = accountService.deposit(id, amount);
        return ResponseEntity.ok().body(ac);
    }

    @PutMapping(value = "/withdraw/{id}/{amount}")
    public ResponseEntity<Accounts> withdraw(@PathVariable Long id,
                                            @PathVariable Double amount)
    {
        Accounts ac = accountService.withdraw(id, amount);
        return ResponseEntity.ok().body(ac);
    }
}
