package com.solvd.deliveryservice.transport;

import com.solvd.deliveryservice.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final public class Scooter extends Transport {
    private final static Logger logger = LogManager.getLogger(Scooter.class.getName());
    
    public Scooter() {
        super(7);
    }

    @Override
    public void travel() {
        logger.info("Road from point A to B");
    }
}