package com.epam.radziievskyi.task6.strategy;

import java.text.ParseException;

public class StrategyInitialization {

    public StrategyInitialization () {
    }

    public void collectStrategy (Strategy strategy) throws ParseException {
        strategy.addProduct();
    }

    public void headerWriter() {
        System.out.println("Choose strategy: " +
                "\n1. Custom strategy" +
                "\n2. Default strategy");
    }

    public int getChoice(String nextLine) {
        return Integer.parseInt(nextLine);
    }

}
