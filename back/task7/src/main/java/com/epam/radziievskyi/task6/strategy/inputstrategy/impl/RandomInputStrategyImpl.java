package com.epam.radziievskyi.task6.strategy.inputstrategy.impl;

import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task6.utils.GenerateRandomUtil;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class RandomInputStrategyImpl implements InputStrategy {

    private static final Logger LOGGER = Logger.getLogger(RandomInputStrategyImpl.class);

    @Override
    public String getString(String message, Scanner scanner) {
        LOGGER.debug("Random string was generated");
        return new GenerateRandomUtil().randomString();
    }

    @Override
    public int getInteger(String message, Scanner scanner) {
        LOGGER.debug("Generated random number ");
        return new GenerateRandomUtil().randomNumbers();
    }

}