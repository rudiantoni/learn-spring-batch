package com.myapps.jdbccursorreader.domain;

public class Client {

    private String firstName;
    private String lastName;
    private String age;
    private String email;


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

    @Override
    public String toString() {
        return "Client{firstName='" + firstName + "', lastName='" + lastName + "', age='" + age + "', email='" + email + "'}";
    }
}
