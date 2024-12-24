package com.solvd.deliveryservice.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadExample extends Thread {
    private final static Logger logger = LogManager.getLogger(ThreadExample.class.getName());

    @Override
    public void run() {
        logger.info("Thread object is running");
    }
}
