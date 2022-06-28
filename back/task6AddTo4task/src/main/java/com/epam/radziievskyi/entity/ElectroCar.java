package com.epam.radziievskyi.entity;

import java.io.Serializable;
import java.util.Objects;

public class ElectroCar extends LandVehicle implements Serializable {

    private String batteryCapacity;

    public ElectroCar(String nameOfProduct, String manufacturerCountry, String brand, String model, int passengers, int year, int maxSpeed, int horsePower, double price, int wheels, String batteryCapacity) {
        super(nameOfProduct, manufacturerCountry, brand, model, passengers, year, maxSpeed, horsePower, price, wheels);
        this.batteryCapacity = batteryCapacity;
    }

    public ElectroCar(String nameOfProduct, String manufacturerCountry, String brand, String model, int passengers, int year, int maxSpeed, int horsePower, double price, int wheels) {
        super(nameOfProduct, manufacturerCountry, brand, model, passengers, year, maxSpeed, horsePower, price, wheels);
    }

    public ElectroCar() {
        super();
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
