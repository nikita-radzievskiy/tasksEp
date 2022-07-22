package com.epam.radziievskyi.task6.exception;

import org.apache.log4j.Logger;

public class UnModException extends Exceptions {

    private final static Logger LOGGER = Logger.getLogger(UnModException.class);

    public UnModException() {
        System.out.println(getMessage());
        LOGGER.debug("Exception in UnModException");
    }

    @Override
    public String getMessage() {
        return "Exception in UnModException";
    }

}