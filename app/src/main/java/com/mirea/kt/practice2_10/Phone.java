package com.mirea.kt.practice2_10;

public class Phone {
    private final String model;
    private final String serialNumber;
    private final int price;

    public Phone(String model, String serialNumber, int price) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getPrice() {
        return price;
    }
}
