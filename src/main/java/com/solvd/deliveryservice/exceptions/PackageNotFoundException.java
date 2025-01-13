package com.solvd.deliveryservice.exceptions;

import com.solvd.deliveryservice.packages.Package;

public class PackageNotFoundException extends Exception {

    public PackageNotFoundException(Package pack) {
        super("Invalid package: " + pack);
    }
}
