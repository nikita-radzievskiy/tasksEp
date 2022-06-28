package com.epam.radziievskyi.shop.controller;

import com.epam.radziievskyi.shop.entity.ExitMarker;
import org.apache.log4j.Logger;

public class ExitCommand implements Command {

    private final static Logger LOGGER = Logger.getLogger(ExitCommand.class);


    private ExitMarker exitMarker;

    public ExitCommand(ExitMarker exitMarker) {
        this.exitMarker = exitMarker;
    }

    @Override
    public void execute() {
        exitMarker.setExitFlag(false);
        LOGGER.info("Exit command was executed");
    }

}
