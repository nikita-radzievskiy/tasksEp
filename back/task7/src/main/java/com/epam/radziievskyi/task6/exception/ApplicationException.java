package com.epam.radziievskyi.task6.exception;

import org.apache.log4j.Logger;

public class ApplicationException extends Exceptions {

    private final static Logger LOGGER = Logger.getLogger(ApplicationException.class);

    public ApplicationException() {
        System.out.println(getMessage());
        LOGGER.debug(getMessage());
    }

    @Override
    public String getMessage() {
        return "Data not serialized yet\n" + "----------------------------------------------------\n";
    }

}