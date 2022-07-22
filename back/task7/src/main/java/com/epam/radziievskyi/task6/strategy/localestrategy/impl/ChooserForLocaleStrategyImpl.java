package com.epam.radziievskyi.task6.strategy.localestrategy.impl;

import com.epam.radziievskyi.task6.strategy.localestrategy.LocaleStrategy;
import org.apache.log4j.Logger;

import java.util.Locale;

public class ChooserForLocaleStrategyImpl implements LocaleStrategy {

    private final static Logger LOGGER = Logger.getLogger(ChooserForLocaleStrategyImpl.class);


    /**
     * This method is used to choose locale for program.
     * user can choose locale by entering number or by entering string.
     * scanner for input
     * 1 - for English locale
     * 2 - for Russian locale
     *
     * @return locale
     */
    @Override
    public Locale getLocale() {
        fillingMap();
        printTypeLocales();
        String chooseLocale = scanner.next();
        while (!locales.containsKey(chooseLocale)) {
            System.out.println("Incorrect. Try again");
            chooseLocale = scanner.next();
        }
        LOGGER.debug("Locale was chosen");
        return locales.get(chooseLocale);
    }

    private void printTypeLocales() {
        System.out.println("Choose language");
        System.out.println("1. Ru");
        System.out.println("2. En");
    }

    private void fillingMap() {
        locales.put("1", RU);
        locales.put("2", EN);
    }

}
