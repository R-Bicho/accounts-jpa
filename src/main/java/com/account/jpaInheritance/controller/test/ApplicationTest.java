package com.account.jpaInheritance.controller.test;

import com.account.jpaInheritance.model.entities.Person;
import com.account.jpaInheritance.model.entities.accounts.Accounts;
import com.account.jpaInheritance.model.entities.accounts.CurrentAccount;
import com.account.jpaInheritance.model.entities.accounts.SavingAccount;
import com.account.jpaInheritance.model.repository.AccountRepository;
import com.account.jpaInheritance.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class ApplicationTest implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {

        Person p1 = new Person(null,"Rogerio", "Santos", "Rogerio-ok@gmail.com", 22);
        Person p2 = new Person(null,"Leticia", "Bicho", "Leticia-ok@gmail.com", 27);

        personRepository.saveAll(Arrays.asList(p1,p2));

        Accounts ac1 = new CurrentAccount(null, 1234, 5678,1000.00, p1, 1000.00);
        Accounts ac2 = new CurrentAccount(null, 5678, 9876,2000.00, p2, 1000.00);

        accountRepository.saveAll(Arrays.asList(ac1,ac2));

        Accounts ac3 = new SavingAccount(null, 1234, 5678,1000.00, p1);
        Accounts ac4 = new SavingAccount(null, 5678, 9876,2000.00, p2);

        accountRepository.saveAll(Arrays.asList(ac3,ac4));

       

    }
}
