package com.epam.radziievskyi.entity;

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

    public Vehicle (String nameOfProduct, String manufacturerCountry, String brand, String model, int passengers, int year, int maxSpeed, int horsePower, double price) {
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

    public Vehicle () {

    }

    public String getNameOfProduct () {
        return nameOfProduct;
    }

    public void setNameOfProduct (String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getManufacturerCountry () {
        return manufacturerCountry;
    }

    public void setManufacturerCountry (String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }


    public int getHorsePower () {
        return horsePower;
    }

    public void setHorsePower (int horsePower) {
        this.horsePower = horsePower;
    }

    public int getPassengers () {
        return passengers;
    }

    public void setPassengers (int passengers) {
        this.passengers = passengers;
    }

    public String getModel () {
        return model;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public String getBrand () {
        return brand;
    }

    public void setBrand (String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed () {
        return maxSpeed;
    }

    public void setMaxSpeed (int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getYear () {
        return year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return passengers == vehicle.passengers && year == vehicle.year && maxSpeed == vehicle.maxSpeed && horsePower == vehicle.horsePower && Double.compare(vehicle.price, price) == 0 && Objects.equals(nameOfProduct, vehicle.nameOfProduct) && Objects.equals(manufacturerCountry, vehicle.manufacturerCountry) && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode () {
        return Objects.hash(nameOfProduct, manufacturerCountry, brand, model, passengers, year, maxSpeed, horsePower, price);
    }

}
