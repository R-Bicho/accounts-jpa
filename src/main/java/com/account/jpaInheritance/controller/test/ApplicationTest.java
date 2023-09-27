package com.account.jpaInheritance.controller.test;

import com.account.jpaInheritance.model.entities.Person;
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

    @Override
    public void run(String... args) throws Exception {

        Person p1 = new Person(null,"Rogerio", "Santos", "Rogerio-ok@gmail.com", 22);
        Person p2 = new Person(null,"Leticia", "Bicho", "Leticia-ok@gmail.com", 27);

        personRepository.saveAll(Arrays.asList(p1,p2));
    }
}
