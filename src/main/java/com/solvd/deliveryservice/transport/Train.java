package com.solvd.deliveryservice.transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final public class Train extends Transport {
    private final static Logger logger = LogManager.getLogger(Train.class.getName());
    
    public Train() {
        super(200);
    }

    @Override
    public void travel() {
        logger.info("Rails from point A to B");
    }
}