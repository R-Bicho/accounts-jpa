package com.account.jpaInheritance.model.entities.accounts;

import com.account.jpaInheritance.model.entities.Person;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_current_account")
public class CurrentAccount extends Accounts implements Serializable {
    @Column(name = "limit_Amount")
    private Double limit;

    public CurrentAccount(){}

    public CurrentAccount(Long id, Integer agency, Integer numberAccount, Double balance, Person person, Double limit) {
        super(id, agency, numberAccount, balance, person);
        this.limit = limit;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    @Override
    public void deposit(Double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(Double amount) {
        if(balance + limit > amount)
        {
            this.balance -= amount;
        }
    }
}
