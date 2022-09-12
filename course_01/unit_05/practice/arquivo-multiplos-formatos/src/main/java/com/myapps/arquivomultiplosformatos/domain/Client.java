package com.myapps.arquivomultiplosformatos.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String firstName;
    private String lastName;
    private String age;
    private String email;

    private List<Transaction> transactions = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + "', lastName='" + lastName + "', age='" + age + "', email='" + email + "'" +
                (transactions.isEmpty() ? ", transactions='[]'" : ", transactions='" + transactions + "'" ) +
                "}";
    }
}
