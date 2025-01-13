package com.solvd.deliveryservice.packages;

public enum PackageTemplate {;

    private final int sizeX;
    private final int sizeY;
    private final int sizeZ;

    PackageTemplate(PackageSize size) {
        switch (size) {
            case LETTER:
                this.sizeX = 30;
                this.sizeY = 10;
                this.sizeZ = 1;
                break;

            case SMALL:
                this.sizeX = 10;
                this.sizeY = 20;
                this.sizeZ = 30;
                break;

            case MEDIUM:
                this.sizeX = 30;
                this.sizeY = 40;
                this.sizeZ = 50;
                break;

            case LARGE:
                this.sizeX = 40;
                this.sizeY = 50;
                this.sizeZ = 60;
                break;

            default:
                this.sizeX = 10;
                this.sizeY = 10;
                this.sizeZ = 10;
                break;
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
}
