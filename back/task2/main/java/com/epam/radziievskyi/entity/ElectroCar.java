package com.epam.radziievskyi.entity;

import java.util.Objects;

public class ElectroCar extends LandVehicle{
    private String batteryCapacity;


    public ElectroCar(String nameOfProduct, String manufacturerCountry, String brand, String model, int passengers, int year, int maxSpeed, int horsePower, double price, int wheels, String batteryCapacity) {
        super(nameOfProduct, manufacturerCountry, brand, model, passengers, year, maxSpeed, horsePower, price, wheels);
        this.batteryCapacity = batteryCapacity;
    }



    @Override
    public String toString() {
        return "ElectroCar{" +
                " nameOfProduct='" + getNameOfProduct() + '\'' +
                ", manufacturerCountry='" + getManufacturerCountry() + '\'' +
                ", price=" + getPrice() +
                ", wheels=" + getWheels() +
                ", horsePower=" + getHorsePower() +
                ", passengers=" + getPassengers() +
                ", model='" + getModel() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear()  + ", batteryCapacity=" +  batteryCapacity +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacity);
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }


}