package com.solvd.deliveryservice.storage;

import java.util.ArrayList;
import java.util.List;
import com.solvd.deliveryservice.packages.Package;

public abstract class Storage implements IStorage {
    private final static int MASK = 10;
    private int maxCapacity;
    private String address;
    private List<Package> packages;
    
    public Storage() {}

    public Storage(int maxCapacity, String address) {
        this.maxCapacity = maxCapacity;
        this.address = address;
        this.packages = new ArrayList<>();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getAddress() {
        return address;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    @Override
    public String toString() {
        return address + ", " + maxCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (hashCode() != obj.hashCode()) return false;
        Storage storage = (Storage) obj;
        return address.equals(storage.address) && maxCapacity == storage.maxCapacity;
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + address.hashCode() + maxCapacity;
    }

    @Override
    public void addPackage(Package pack) {
        this.packages.add(pack);
    }

    @Override
    public void removePackage(Package pack) {
        this.packages.remove(pack);
    }

    @Override
    public Package getPackage(Package pack) {
        return this.packages.get(this.packages.indexOf(pack));
    }
}