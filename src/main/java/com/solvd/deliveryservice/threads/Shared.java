package com.solvd.deliveryservice.threads;

import com.solvd.deliveryservice.connections.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shared {
    private final static Logger logger = LogManager.getLogger(Shared.class.getName());

    synchronized void operation1(Shared s2) {
        logger.info("{} started operation1 of {}", Thread.currentThread().getName(), this);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        s2.operation2();
        logger.info("{} exited operation1 of {}", Thread.currentThread().getName(), this);
    }
    synchronized void operation2() {
        logger.info("{} started operation2 of {}", Thread.currentThread().getName(), this);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("{} exited operation2 of {}", Thread.currentThread().getName(), this);
    }
}
