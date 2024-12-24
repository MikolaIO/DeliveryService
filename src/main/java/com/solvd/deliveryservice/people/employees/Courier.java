package com.solvd.deliveryservice.people.employees;

import com.solvd.deliveryservice.people.Employee;
import com.solvd.deliveryservice.request.DeliveryRequest;
import com.solvd.deliveryservice.transport.Transport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Courier extends Employee implements ICourier {
    private final static Logger logger = LogManager.getLogger(Courier.class.getName());
    private double phoneNumber;
    private Transport transport;
    private DeliveryRequest request;

    public Courier() {}

    public Courier(String firstName, String lastName, int age, double phoneNumber, Transport transport) {
        super(firstName, lastName, age);
        this.phoneNumber = phoneNumber;
        this.transport = transport;
        this.request = null;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public Transport getTransport() {
        return transport;
    }

    public DeliveryRequest getRequest() {
        return request;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setRequest(DeliveryRequest request) {
        this.request = request;
    }

    @Override
    public void deliverPackage() {
        logger.info("Courier collects packages from storage and delivers them to customer according to DeliveryRequest");
    }

    @Override
    public void work() {
        deliverPackage();
    }


}