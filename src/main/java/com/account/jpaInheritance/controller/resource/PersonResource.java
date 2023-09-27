package com.account.jpaInheritance.controller.resource;

import com.account.jpaInheritance.model.entities.Person;
import com.account.jpaInheritance.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAll()
    {
        List<Person> personList = personService.findAll();
        return ResponseEntity.ok().body(personList);
    }
}
