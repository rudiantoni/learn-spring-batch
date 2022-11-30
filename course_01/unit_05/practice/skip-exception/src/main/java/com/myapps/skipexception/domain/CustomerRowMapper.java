package com.myapps.skipexception.domain;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomerRowMapper implements RowMapper<Customer> {


    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        if(rs.getRow() == 15) { // Force error in the last row read
            throw new SQLException(String.format("Terminating execution: Invalid customer %s.", rs.getString("email")));
        }
        else {
            return customerRowMapper(rs);
        }
    }

    private Customer customerRowMapper(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerFirstName(rs.getString("first_name"));
        customer.setCustomerLastName(rs.getString("last_name"));
        customer.setCustomerEmail(rs.getString("email"));
        customer.setCustomerAge(rs.getString("age"));
        return customer;
    }
}
