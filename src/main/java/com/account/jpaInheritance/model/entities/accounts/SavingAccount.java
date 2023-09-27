package com.account.jpaInheritance.model.entities.accounts;

import com.account.jpaInheritance.model.entities.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tb_saving_account")
public class SavingAccount extends Accounts implements Serializable {
    public SavingAccount(){}

    public SavingAccount(Long id, Integer agency, Integer numberAccount, Double balance, Person person) {
        super(id, agency, numberAccount, balance, person);
    }

    @Override
    public void deposit(Double amount) {

    }

    @Override
    public void withdraw(Double amount) {

    }
}
