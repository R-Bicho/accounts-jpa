package com.account.jpaInheritance.model.service;

import com.account.jpaInheritance.model.entities.Person;
import com.account.jpaInheritance.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll()
    {
       return personRepository.findAll();
    }

}
