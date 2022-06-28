package com.epam.radziievskyi.entity;

public class LandVehicle extends Vehicle {
    private int wheels;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public LandVehicle(String nameOfProduct, String manufacturerCountry, String brand, String model, int passengers, int year, int maxSpeed, int horsePower, double price, int wheels) {
        super(nameOfProduct, manufacturerCountry, brand, model, passengers, year, maxSpeed, horsePower, price);
        this.wheels = wheels;
    }
}
