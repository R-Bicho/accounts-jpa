package com.account.jpaInheritance.model.entities.accounts;

import com.account.jpaInheritance.model.entities.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_account")
public abstract class Accounts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer agency;
    private Integer numberAccount;
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "person_account")
    @JsonIgnore
    private Person person;

    public Accounts(){}
    public Accounts(Long id, Integer agency, Integer numberAccount, Double balance, Person person) {
        this.id = id;
        this.agency = agency;
        this.numberAccount = numberAccount;
        this.balance = balance;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgency() {
        return agency;
    }

    public void setAgency(Integer agency) {
        this.agency = agency;
    }

    public Integer getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Integer numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Double getBalance() {
        return balance;
    }

    public Person getPerson() {
        return person;
    }

    public abstract void deposit(Double amount);
    public abstract void withdraw(Double amount);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accounts that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
