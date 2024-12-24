package com.solvd.deliveryservice.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    static final int THREAD_POOL_SIZE = 7;
    private final static Logger logger = LogManager.getLogger(Runner.class.getName());

    public static void main(String[] args) {

        ConnectionPool connectionPool = ConnectionPool.getInstance();

        Task t1 = new Task(connectionPool);
        Task t2 = new Task(connectionPool);
        Task t3 = new Task(connectionPool);
        Task t4 = new Task(connectionPool);
        Task t5 = new Task(connectionPool);
        Task t6 = new Task(connectionPool);
        Task t7 = new Task(connectionPool);

        final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Future<String> future1 = threadPool.submit(t1);
        Future<String> future2 = threadPool.submit(t2);
        Future<String> future3 = threadPool.submit(t3);
        Future<String> future4 = threadPool.submit(t4);
        Future<String> future5 = threadPool.submit(t5);
        Future<String> future6 = threadPool.submit(t6);
        Future<String> future7 = threadPool.submit(t7);

        try {
            logger.info(future1.get());
            logger.info(future2.get());
            logger.info(future3.get());
            logger.info(future4.get());
            logger.info(future5.get());
            logger.info(future6.get());
            logger.info(future7.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        threadPool.shutdown();
    }
}
