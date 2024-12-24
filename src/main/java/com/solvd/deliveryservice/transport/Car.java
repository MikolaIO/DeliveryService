package com.solvd.deliveryservice.transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final public class Car extends Transport {
    private final static Logger logger = LogManager.getLogger(Car.class.getName());

    public Car() {
        super(50);
    }

    @Override
    public void travel() {
        logger.info("Road from A to B");
    }
}