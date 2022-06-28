package com.epam.radziievskyi.task6.utils;

import org.apache.log4j.Logger;

import java.util.Random;

public class GenerateRandomUtil {

    private static final Logger LOGGER = Logger.getLogger(GenerateRandomUtil.class);

    public int randomNumbers() {
        Random rand = new Random();
        int upperbound = Integer.MAX_VALUE;
        LOGGER.debug("Generated random number " + rand.nextInt(upperbound));
        return rand.nextInt(upperbound);
    }

}
