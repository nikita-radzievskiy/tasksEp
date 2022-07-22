package com.epam.radziievskyi.task6.utils;

import org.apache.log4j.Logger;

import java.util.Random;

public class GenerateRandomUtil {

    private static final Logger LOGGER = Logger.getLogger(GenerateRandomUtil.class);

    public String forStringValue () {
        Random rand = new Random();
        int upperbound = Integer.MAX_VALUE;
        LOGGER.debug("Generated random number " + rand.nextInt(upperbound));
        return "Фирма " + rand.nextInt(upperbound);
    }

    public int randomNumbers () {
        Random rand = new Random();
        int number = rand.nextInt(100);
        LOGGER.debug("Generated random number " + number);
        return number;
    }

}
