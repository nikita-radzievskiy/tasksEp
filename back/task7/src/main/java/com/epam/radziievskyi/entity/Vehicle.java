package com.epam.radziievskyi.entity;

import com.epam.radziievskyi.task7_1.annotation.ProductSetter;

import java.io.Serializable;
import java.util.Objects;

public abstract class Vehicle implements Serializable {
    private String nameOfProduct;
    private String manufacturerCountry;
    private String brand;
    private String model;
    private int passengers;
    private int year;
    private int maxSpeed;
    private int horsePower;
    private double price;

    public Vehicle(String nameOfProduct, String manufacturerCountry, String brand, String model, int passengers, int year, int maxSpeed, int horsePower, double price) {
        this.nameOfProduct = nameOfProduct;
        this.manufacturerCountry = manufacturerCountry;
        this.brand = brand;
        this.model = model;
        this.passengers = passengers;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.horsePower = horsePower;
        this.price = price;
    }

    public Vehicle() {
    }

    @ProductSetter(name = "getNameOfProduct")
    public String getNameOfProduct() {
        return nameOfProduct;
    }

    @ProductSetter(name = "setNameOfProduct")
    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    @ProductSetter(name = "getManufacturerCountry")
    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    @ProductSetter(name = "setManufacturerCountry")
    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    @ProductSetter(name = "getPrice")
    public double getPrice() {
        return price;
    }

    @ProductSetter(name = "setPrice")
    public void setPrice(double price) {
        this.price = price;
    }

    @ProductSetter(name = "getHorsePower")
    public int getHorsePower() {
        return horsePower;
    }

    @ProductSetter(name = "setHorsePower")
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @ProductSetter(name = "getPassengers")
    public int getPassengers() {
        return passengers;
    }

    @ProductSetter(name = "setPassengers")
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @ProductSetter(name = "getModel")
    public String getModel() {
        return model;
    }

    @ProductSetter(name = "setModel")
    public void setModel(String model) {
        this.model = model;
    }

    @ProductSetter(name = "getBrand")
    public String getBrand() {
        return brand;
    }

    @ProductSetter(name = "setBrand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @ProductSetter(name = "getMaxSpeed")
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @ProductSetter(name = "setMaxSpeed")
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @ProductSetter(name = "getYear")
    public int getYear() {
        return year;
    }

    @ProductSetter(name = "setYear")
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return passengers == vehicle.passengers && year == vehicle.year && maxSpeed == vehicle.maxSpeed && horsePower == vehicle.horsePower && Double.compare(vehicle.price, price) == 0 && Objects.equals(nameOfProduct, vehicle.nameOfProduct) && Objects.equals(manufacturerCountry, vehicle.manufacturerCountry) && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfProduct, manufacturerCountry, brand, model, passengers, year, maxSpeed, horsePower, price);
    }

}
