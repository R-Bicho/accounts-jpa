package com.account.jpaInheritance.model.service;

import com.account.jpaInheritance.model.entities.Person;
import com.account.jpaInheritance.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll()
    {
       return personRepository.findAll();
    }
    public Optional<Person> findById(Long id)
    {
        return personRepository.findById(id);
    }

    public Person insert(Person person)
    {
        return personRepository.save(person);
    }

    public void deleteById(Long id)
    {
        personRepository.deleteById(id);
    }

    public Person update(Long id, Person obj)
    {
        Person entity = personRepository.getReferenceById(id);
        updateData(entity, obj);
        return personRepository.save(entity);
    }

    private void updateData(Person entity, Person obj)
    {
        entity.setFirstName(obj.getFirstName());
        entity.setLastName(obj.getLastName());
        entity.setEmail(obj.getEmail());
        entity.setAge(obj.getAge());
    }
}
