package com.epam.radziievskyi.shop.controller;

import com.epam.radziievskyi.shop.entity.ExitMarker;
import org.apache.log4j.Logger;

public class ExitCommand implements Command {

    private final static Logger LOGGER = Logger.getLogger(ExitCommand.class);

    private final ExitMarker exitMarker;

    public ExitCommand (ExitMarker exitMarker) {
        this.exitMarker = exitMarker;
    }

    @Override
    public void execute () {
        exitMarker.setExitFlag(false);
        System.out.println("\nGoodbye!");
        System.out.println("Serialization is successful");
        LOGGER.info("Exit command was executed");
    }

}
