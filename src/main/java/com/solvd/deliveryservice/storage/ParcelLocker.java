package com.solvd.deliveryservice.storage;

public class ParcelLocker extends Storage {

    public ParcelLocker() {}

    public ParcelLocker(int maxCapacity, String address) {
        super(maxCapacity, address);
    }
}