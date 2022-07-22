package com.epam.radziievskyi.entity;

import java.io.Serializable;
import java.util.Objects;

public class SeaVehicle extends Vehicle implements Serializable {
    private String materialOfShip;

    public SeaVehicle (String nameOfProduct, String manufacturerCountry, String brand, String model, int passengers, int year, int maxSpeed, int horsePower, double price, String materialOfShip) {
        super(nameOfProduct, manufacturerCountry, brand, model, passengers, year, maxSpeed, horsePower, price);
        this.materialOfShip = materialOfShip;
    }

    public SeaVehicle () {

    }

    public String getMaterialOfShip () {
        return materialOfShip;
    }

    public void setMaterialOfShip (String materialOfShip) {
        this.materialOfShip = materialOfShip;
    }

    @Override
    public String toString () {
        return "SeaVehicle{" +
                "materialOfShip='" + materialOfShip + '\'' +
                ", nameOfProduct='" + getNameOfProduct() + '\'' +
                ", manufacturerCountry='" + getManufacturerCountry() + '\'' +
                ", price=" + getPrice() +
                ", horsePower=" + getHorsePower() +
                ", passengers=" + getPassengers() +
                ", model='" + getModel() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                '}';
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        SeaVehicle that = (SeaVehicle) object;
        return Objects.equals(materialOfShip, that.materialOfShip);
    }

}
