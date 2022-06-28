package com.epam.radziievskyi.task6.strategy.impl;

import com.epam.radziievskyi.task6.adderutil.RandomAdderUtil;
import com.epam.radziievskyi.task6.strategy.Strategy;

public class RandomStrategyImpl implements Strategy {

    private final RandomAdderUtil randomAdder = new RandomAdderUtil();

    @Override
    public void addProduct() {
        randomAdder.addProduct();
    }

    @Override
    public void chooseStrategy(String choice) {
        if (choice.equals("2")) {
            addProduct();
        } else {
            new CustomStrategyImpl().addProduct();
        }
    }

}
