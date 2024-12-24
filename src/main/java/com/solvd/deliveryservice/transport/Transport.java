package com.solvd.deliveryservice.transport;

import com.solvd.deliveryservice.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Transport {
    private final static Logger logger = LogManager.getLogger(Transport.class.getName());
    private int maxCapacity;

    public Transport() {}

    public Transport(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public abstract void travel();

    static {
        logger.info("Created transport object");
    }
}