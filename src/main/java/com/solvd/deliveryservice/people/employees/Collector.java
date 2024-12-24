package com.solvd.deliveryservice.people.employees;

import com.solvd.deliveryservice.Main;
import com.solvd.deliveryservice.people.Employee;
import com.solvd.deliveryservice.request.DeliveryRequest;
import com.solvd.deliveryservice.storage.Storage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Collector extends Employee implements ICollector {
    private final static Logger logger = LogManager.getLogger(Collector.class.getName());
    private int queue;

    public Collector() {}
    
    public Collector(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.queue = 0;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public void storeRequestPackage(Storage storage, DeliveryRequest request) {
        storage.addPackage(request.getPack());
    }
    public void giveCourier(Storage storage, DeliveryRequest request, Courier courier) {
        courier.setRequest(request);
        storage.removePackage(request.getPack());
    }

    @Override
    public void work() {
        logger.info("Collects the packages and puts them into storage or passes to the Courier");
    }
}