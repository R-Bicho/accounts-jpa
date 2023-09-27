package com.account.jpaInheritance.model.repository;

import com.account.jpaInheritance.model.entities.Person;
import com.account.jpaInheritance.model.entities.accounts.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts, Long> {
}
