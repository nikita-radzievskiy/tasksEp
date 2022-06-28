package com.epam.radziievskyi.shop;

import com.epam.radziievskyi.shop.utils.ApplicationManager;
import org.apache.log4j.Logger;

import java.text.ParseException;

public class Runner {

    private final static Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main(String[] args) throws ParseException {
        LOGGER.info("Application started");
        new ApplicationManager().run();
    }

}
