package com.epam.radziievskyi.task6.strategy.impl;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.adderutil.CustomAdderUtil;
import com.epam.radziievskyi.task6.strategy.Strategy;

import java.util.List;

public class CustomStrategyImpl implements Strategy {

    private final CustomAdderUtil customAdder = new CustomAdderUtil();

    @Override
    public void addProduct() {
        customAdder.addProduct();
    }

    @Override
    public void chooseStrategy(String choice) {
        if (choice.equals("1")) {
            addProduct();
        } else {
            new RandomStrategyImpl().addProduct();
        }
    }

    public List<Vehicle> getAllVehicles() {
        return customAdder.getAllVehicles();
    }

}

