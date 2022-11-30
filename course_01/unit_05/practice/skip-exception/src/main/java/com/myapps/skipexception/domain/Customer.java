package com.myapps.skipexception.domain;

public class Customer {
    private String customerFirstName;
    private String customerLastName;
    private String customerAge;
    private String customerEmail;

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "Customer{customerFirstName='" + customerFirstName + "', customerLastName='" + customerLastName + "', customerAge='" + customerAge + "', customerEmail='" + customerEmail + "'}";
    }

}
