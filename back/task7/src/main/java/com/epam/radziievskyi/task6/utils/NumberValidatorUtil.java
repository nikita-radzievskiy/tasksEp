package com.epam.radziievskyi.task6.utils;

import org.apache.log4j.Logger;

import java.util.Random;

public class NumberValidatorUtil {

    private static final Logger LOGGER = Logger.getLogger(NumberValidatorUtil.class);

    private final Random random = new Random();

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            LOGGER.debug("Number is valid");
            return true;
        } catch (NumberFormatException e) {
            LOGGER.debug("Number is not valid");
            return false;
        }
    }

    public int validateIntegerInput(String input) {
        if (isNumber(input)) {
            LOGGER.debug("Input is valid");
            return Integer.parseInt(input);
        } else {
            LOGGER.debug("Input is not valid");
            System.out.println("Incorrect. Added random number");
            return random.nextInt(4);
        }
    }

}
