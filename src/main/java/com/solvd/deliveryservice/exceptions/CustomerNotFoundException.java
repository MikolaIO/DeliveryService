package com.solvd.deliveryservice.exceptions;

import com.solvd.deliveryservice.people.customers.Customer;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException(Customer customer) {
        super("Invalid customer: " + customer);
    }
}
