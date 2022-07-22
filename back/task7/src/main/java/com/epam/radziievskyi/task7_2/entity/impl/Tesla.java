package com.epam.radziievskyi.task7_2.entity.impl;

import com.epam.radziievskyi.task7_2.entity.VehicleInterface;

public class Tesla implements VehicleInterface {

    private String nameOfProduct;
    private String manufacturerCountry;
    private String brand;
    private String model;
    private int passengers;
    private int year;
    private int maxSpeed;
    private int horsePower;
    private int price;
    private int wheels;
    private String batteryCapacity;

    public Tesla(String nameOfProduct, String manufacturerCountry, String brand, String model, int passengers, int year, int maxSpeed, int horsePower, int price, int wheels, String batteryCapacity) {
        this.nameOfProduct = nameOfProduct;
        this.manufacturerCountry = manufacturerCountry;
        this.brand = brand;
        this.model = model;
        this.passengers = passengers;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.horsePower = horsePower;
        this.price = price;
        this.wheels = wheels;
        this.batteryCapacity = batteryCapacity;
    }

    public Tesla() {

    }

    @Override
    public String getNameOfProduct() {
        return nameOfProduct;
    }

    @Override
    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    @Override
    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    @Override
    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }

    @Override
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return "ElectroCar{" + " model '" + getModel() + '\'' + ", brand '" + getBrand() + '\'' + ", name of product '"
                + getNameOfProduct() + '\'' + ", price '"
                + getPrice() + '\'' + ", country '" + getManufacturerCountry() + '\'' + ", year '" + getYear() + '\''
                + ", maxSpeed '" + getMaxSpeed() + '\''
                + ", horse power '" + getHorsePower() + '\'' +
                ", passengers '" + getPassengers() + '\'' + ", battery capacity '" + getBatteryCapacity() + '\''
                + ", wheels '" + getWheels() + '\'' + '}';
    }

}
