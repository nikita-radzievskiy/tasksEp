package com.epam.radziievskyi.task6.utils;

import org.apache.log4j.Logger;

public class NumberValidatorUtil {

    private static final Logger LOGGER = Logger.getLogger(NumberValidatorUtil.class);

    public static boolean isNumber (String input) {
        try {
            Integer.parseInt(input);
            LOGGER.debug("Number is valid");
            return true;
        } catch (NumberFormatException e) {
            LOGGER.debug("Number is not valid");
            return false;
        }
    }

    public int validateIntegerInput (String input) {
        if (isNumber(input)) {
            LOGGER.debug("Input is valid");
            return Integer.parseInt(input);
        } else {
            LOGGER.debug("Input is not valid");
            System.out.println("Введите число");
            return -1;
        }
    }

}
