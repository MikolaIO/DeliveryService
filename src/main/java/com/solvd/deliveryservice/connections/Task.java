package com.solvd.deliveryservice.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    private final static Logger logger = LogManager.getLogger(Task.class.getName());
    private ConnectionPool pool;

    public Task(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            try {
                if (pool.getConnectedSize() == pool.getSize()) {
                    logger.info(Thread.currentThread().getName());
                    logger.info("Waiting for available connection");
                    Thread.sleep(5000);
                }
                pool.getConnection();
                Thread.sleep(5000);
                pool.releaseConnection();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "Success";
    }
}
