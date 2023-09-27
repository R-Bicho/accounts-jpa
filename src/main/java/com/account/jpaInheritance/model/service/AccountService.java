package com.account.jpaInheritance.model.service;

import com.account.jpaInheritance.model.entities.accounts.Accounts;
import com.account.jpaInheritance.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Accounts> findAll()
    {
       return accountRepository.findAll();
    }

}
