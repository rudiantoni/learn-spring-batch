package com.myapps.jdbcpagingreader.domain;

public class Client {

    private String first_name;
    private String last_name;
    private String age;
    private String email;

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
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
        return "Client{" +
            "nome='" + first_name + '\'' +
            ", sobrenome='" + last_name + '\'' +
            ", idade='" + age + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
