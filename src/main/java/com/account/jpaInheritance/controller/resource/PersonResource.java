package com.account.jpaInheritance.controller.resource;

import com.account.jpaInheritance.model.entities.Person;
import com.account.jpaInheritance.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Person>> findById(@PathVariable Long id)
    {
        Optional<Person> person = personService.findById(id);
        return ResponseEntity.ok().body(person);
    }

    @PostMapping
    public ResponseEntity<Person> insert(@RequestBody Person obj)
    {
        Person person = personService.insert(obj);
        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id)
    {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person obj)
    {
        Person person = personService.update(id, obj);
        return ResponseEntity.ok().body(person);
    }
}
