package com.epam.radziievskyi.utils;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterUtils {
    public static List<Vehicle> filter(List<Vehicle> filter, Predicate<? extends Vehicle> predicate) {
        return filter.stream().filter((Predicate<? super Vehicle>) predicate).collect(Collectors.toList());
    }


    public static Predicate<Vehicle> speedBiggestThen(int maxSpeed) {
        return p -> p.getMaxSpeed() > maxSpeed;
    }

    public static Predicate<Vehicle> speedLowerThen(int maxSpeed) {
        return p -> p.getMaxSpeed() < maxSpeed;

    }

    public static Predicate<ElectroCar> priceBiggestThan(double price) {
        return p -> p.getPrice() > price;
    }

    public static Predicate<ElectroCar> priceLowerThan(double price) {
        return p -> p.getPrice() < price;
    }

    public static Predicate<ElectroCar> earlierYear(int year) {
        return p -> p.getYear() < year;
    }

    public static Predicate<ElectroCar> oldestYear(int year) {
        return p -> p.getYear() > year;
    }


    public static Predicate<ElectroCar> isModel(String model) {
        return p -> p.getModel().equals(model);
    }

    public static Predicate<ElectroCar> isCountry(String country) {
        return p -> p.getManufacturerCountry().equals(country);
    }

    public static Predicate<ElectroCar> isBrand(String brand) {
        return p -> p.getBrand().equals(brand);
    }

    public static Predicate<ElectroCar> isNameOfProduct(String nameOfProduct) {
        return p -> p.getNameOfProduct().equals(nameOfProduct);
    }


}
