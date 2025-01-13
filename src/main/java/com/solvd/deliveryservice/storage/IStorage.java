package com.solvd.deliveryservice.storage;

import com.solvd.deliveryservice.packages.Package;

public interface IStorage {
    void addPackage(Package pack);

    void removePackage(Package pack);

    Package getPackage(Package pack);
}
