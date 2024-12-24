package com.solvd.deliveryservice.request;

import com.solvd.deliveryservice.packages.Package;
import com.solvd.deliveryservice.people.customers.Customer;

public class DeliveryRequest {
    private int id;
    private static int idCounter = 1;
    private Customer customer;
    private Package pack;

    public DeliveryRequest() {}

    public DeliveryRequest(Customer customer, Package pack) {
        this.customer = customer;
        this.pack = pack;
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Package getPack() {
        return pack;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }
}