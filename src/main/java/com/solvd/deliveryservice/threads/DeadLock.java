package com.solvd.deliveryservice.threads;

public class DeadLock {

    public static void main(String[] args) {
        Shared s1 = new Shared();
        Shared s2 = new Shared();
        Thread1 t1 = new Thread1(s1, s2);
        Thread2 t2 = new Thread2(s1, s2);
        t1.setName("Thread 1");
        t1.start();
        t2.setName("Thread 2");
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
