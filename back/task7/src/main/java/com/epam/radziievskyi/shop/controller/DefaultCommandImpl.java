package com.epam.radziievskyi.shop.controller;

import org.apache.log4j.Logger;

public class DefaultCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(DefaultCommandImpl.class);

    @Override
    public void execute() {
        System.out.println("Incorrect");
        LOGGER.debug("Incorrect command");
    }

}
