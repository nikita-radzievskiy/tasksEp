package com.epam.radziievskyi.task6.strategy.inputstrategy.impl;

import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task6.utils.NumberValidatorUtil;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class ConsoleInputStrategyImpl implements InputStrategy {

    private static final Logger LOGGER = Logger.getLogger(ConsoleInputStrategyImpl.class);
    private final NumberValidatorUtil numberValidator = new NumberValidatorUtil();

    public ConsoleInputStrategyImpl() {
    }

    @Override
    public String getString(String message, Scanner scanner) {
        System.out.print(message);
        LOGGER.debug("String was entered");
        return scanner.nextLine();
    }

    @Override
    public int getInteger(String message, Scanner scanner) {
        System.out.print(message);
        LOGGER.debug("Integer was entered");
        return numberValidator.validateIntegerInput(scanner.nextLine());
    }

}