package com.solvd.deliveryservice.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionPool {
    private final static Logger logger = LogManager.getLogger(ConnectionPool.class.getName());
    private CopyOnWriteArrayList<Connection> pool;
    private CopyOnWriteArrayList<Connection> connectedPool = new CopyOnWriteArrayList<>();
    private static final int INITIAL_POOL_SIZE = 5;
    private static ConnectionPool INSTANCE;

    private ConnectionPool() {
        this.pool = new CopyOnWriteArrayList<>();
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection());
        }
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ConnectionPool();
        return INSTANCE;
    }

    public int getSize() {
        return INITIAL_POOL_SIZE;
    }

    public int getConnectedSize() {
        return connectedPool.size();
    }

    public void getConnection() {
        Connection connection = pool.getLast();
        connectedPool.add(connection);
        logger.info("Got connection");
    }

    public void releaseConnection() {
        pool.add(connectedPool.getLast());
        connectedPool.removeLast();
        logger.info("Released connection");
    }

    private static Connection createConnection() {
        logger.info("Created connection");
        return new Connection();
    }
}
