package com.epam.radziievskyi.entity;

import java.io.Serializable;
import java.util.Objects;

public class BenzoCar extends LandVehicle implements Serializable {
    private String fuelCapacity;

    public BenzoCar () {
        super();
    }

    public BenzoCar (String nameOfProduct, String manufacturerCountry, String brand, String model, int passengers, int year, int maxSpeed, int horsePower, double price, int wheels, String fuelCapacity) {
        super(nameOfProduct, manufacturerCountry, brand, model, passengers, year, maxSpeed, horsePower, price, wheels);
        this.fuelCapacity = fuelCapacity;

    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BenzoCar benzoCar = (BenzoCar) object;
        return Objects.equals(fuelCapacity, benzoCar.fuelCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fuelCapacity);
    }

    @Override
    public String toString() {
        return "BenzoCar{" + " model '" + getModel() + '\'' + ", brand '" + getBrand() + '\'' + ", name of product '"
                + getNameOfProduct() + '\'' + ", price '"
                + getPrice() + '\'' + ", country '" + getManufacturerCountry() + '\'' + ", year '"
                + getYear() + '\'' + ", maxSpeed '" + getMaxSpeed() + '\''
                + ", horse power '" + getHorsePower() + '\'' +
                ", passengers '" + getPassengers() + '\'' + ", fuel capacity '" + getFuelCapacity() + '\''
                + ", wheels '" + getWheels() + '\'' + '}';
    }


    public String getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }


}
