package com.account.jpaInheritance.model.repository;

import com.account.jpaInheritance.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
