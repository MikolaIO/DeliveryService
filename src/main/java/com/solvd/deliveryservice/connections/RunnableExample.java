package com.solvd.deliveryservice.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableExample implements Runnable {
    private final static Logger logger = LogManager.getLogger(RunnableExample.class.getName());

    @Override
    public void run() {
        logger.info("Runnable object is running");
    }
}
