package com.solvd.deliveryservice.packages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Package {
    private final static Logger logger = LogManager.getLogger(Package.class.getName());
    private final static int mask = 10;
    private int sizeX;
    private int sizeY;
    private int sizeZ;
    private int weight;
    
    public Package() {}

    public Package(int[] dimensions, int weight) {
        if (dimensions.length == 3 && dimensions[0] > 0 && dimensions[1] > 0 && dimensions[2] > 0 && weight > 0) {
            this.sizeX = dimensions[0];
            this.sizeY = dimensions[1];
            this.sizeZ = dimensions[2];
            this.weight = weight;
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getSizeZ() {
        return sizeZ;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Size: " + sizeX + ", " + sizeY + ", " + sizeZ + ", Weight: " + weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (hashCode() != obj.hashCode()) return false;
        Package pack = (Package) obj;
        return sizeX == pack.sizeX && sizeY == pack.sizeY && sizeZ == pack.sizeZ && weight == pack.weight;
    }

    @Override
    public int hashCode() {
        return mask + super.hashCode() + sizeX + sizeY + sizeZ + weight;
    }

    public static <T> void displayData(T element) {
        logger.info(element);
    }
}