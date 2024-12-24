package com.solvd.deliveryservice.transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final public class Bike extends Transport {
    private final static Logger logger = LogManager.getLogger(Bike.class.getName());

    public Bike() {
        super(4);
    }

    @Override
    public void travel() {
        logger.info("Ride from A to B");
    }
}