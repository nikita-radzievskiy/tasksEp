package com.epam.radziievskyi.task6;

import com.epam.radziievskyi.task6.strategy.Strategy;
import com.epam.radziievskyi.task6.strategy.StrategyInitialization;
import com.epam.radziievskyi.task6.strategy.impl.CustomStrategyImpl;
import com.epam.radziievskyi.task6.strategy.impl.RandomStrategyImpl;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Scanner;

public class Runner4Task6 {

    private static final Logger LOGGER = Logger.getLogger(Runner4Task6.class);
    private static final StrategyInitialization initialization = new StrategyInitialization();

    public static void main (String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Strategy strategyInterface;

        initialization.headerWriter();
        int strategyChoice = initialization.getChoice(sc.nextLine());
        if (strategyChoice == 2) {
            LOGGER.info("Default strategy was chosen");
            strategyInterface = new RandomStrategyImpl();
        } else {
            LOGGER.info("Custom strategy was chosen");
            strategyInterface = new CustomStrategyImpl();
        }
        initialization.collectStrategy(strategyInterface);
    }

}
