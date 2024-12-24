package com.solvd.deliveryservice.transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final public class Plane extends Transport {
    private final static Logger logger = LogManager.getLogger(Plane.class.getName());

    public Plane() {
        super(500);
    }

    @Override
    public void travel() {
        logger.info("Flight from A to B");
    }
}