package com.solvd.deliveryservice.people.customers;

import com.solvd.deliveryservice.Main;
import com.solvd.deliveryservice.people.Person;
import com.solvd.deliveryservice.request.DeliveryPreference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Customer extends Person implements ICustomer {
    private final static Logger logger = LogManager.getLogger(Customer.class.getName());
    private final static int mask = 10;
    private String address;
    private DeliveryPreference preference;

    public Customer() {}

    public Customer(String firstName, String lastName, int age, String address, DeliveryPreference preference) {
        super(firstName, lastName, age);
        this.address = address;
        this.preference = preference;
    }

    public String getAddress() {
        return address;
    }

    public DeliveryPreference getPreference() {
        return preference;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPreference(DeliveryPreference preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "Address: " + address + ", Preference: " + preference;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (hashCode() != obj.hashCode()) return false;
        Customer customer = (Customer) obj;
        return address.equals(customer.address) && preference.equals(customer.preference);
    }

    @Override
    public int hashCode() {
        return mask + super.hashCode() + address.hashCode() + preference.hashCode();
    }

    @Override
    public void order() {
        logger.info("Customer places the DeliveryRequest");
    }

    @Override
    public void confirmDelivery() {
        logger.info("Customer checks the delivery according to preference and removes the request in case of success");
    }
}