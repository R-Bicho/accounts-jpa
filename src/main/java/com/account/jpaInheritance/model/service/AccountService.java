package com.account.jpaInheritance.model.service;

import com.account.jpaInheritance.model.entities.Person;
import com.account.jpaInheritance.model.entities.accounts.Accounts;
import com.account.jpaInheritance.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Accounts> findAll()
    {
       return accountRepository.findAll();
    }

    public Optional<Accounts> findById(Long id)
    {
        return accountRepository.findById(id);
    }

    public Accounts insert(Accounts obj)
    {
        return accountRepository.save(obj);
    }

    public void deleteById(Long id)
    {
        accountRepository.deleteById(id);
    }

    public Accounts update(Long id, Accounts obj)
    {
        Accounts entity = accountRepository.getReferenceById(id);
        updateData(entity, obj);
        return accountRepository.save(entity);
    }

    private void updateData(Accounts entity, Accounts obj)
    {
        entity.setAgency(obj.getAgency());
        entity.setNumberAccount(obj.getNumberAccount());
    }

}
