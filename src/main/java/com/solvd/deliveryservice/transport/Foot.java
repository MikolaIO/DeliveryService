package com.solvd.deliveryservice.transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final public class Foot extends Transport {
    private final static Logger logger = LogManager.getLogger(Foot.class.getName());

    public Foot() {
        super(1);
    }

    @Override
    public void travel() {
        logger.info("Walk from A to B");
    }
}