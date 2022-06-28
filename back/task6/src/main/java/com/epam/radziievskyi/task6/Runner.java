package com.epam.radziievskyi.task6;

import com.epam.radziievskyi.task6.utils.InitializationAppUtil;
import org.apache.log4j.Logger;

public class Runner {

    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main(String[] args) {
        LOGGER.info("Application was started");
        new InitializationAppUtil().run();
    }

}
