package com.epam.radziievskyi.filereader.chainofrespon.util;

import org.apache.log4j.Logger;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validator {

    private final static Logger LOGGER = Logger.getLogger(Validator.class);

    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static boolean isNumberValid (Scanner scanner) {
        LOGGER.info("Checking is number valid");
        String number;
        while (scanner.hasNext()) {
            number = scanner.next();
            if (number.equals("1")) {
                return true;
            }
            if (number.equals("0")) {
                return false;
            }
            System.out.println("Incorrect Number try again");
        }
        LOGGER.error("No number entered");
        return false;
    }

    public static long validNumberInput (Scanner scanner) {
        LOGGER.info("Checking valid number input");
        long number = -1;
        try {
            number = Long.parseLong(scanner.next());
        } catch (NumberFormatException exception) {
            System.out.println("Invalid number try again");
            validNumberInput(scanner);
            LOGGER.error("Invalid number entered");
        }
        LOGGER.info("Number entered");
        return number;
    }

    public static String validDateInput (Scanner scanner) {
        LOGGER.info("Checking date");
        LocalDate localDate = null;
        try {
            String date = scanner.next();
            localDate = LocalDate.parse(date, DATE_TIME_FORMATTER);
        } catch (DateTimeException | NullPointerException exception) {
            System.out.println("Incorrect date try again");
            validDateInput(scanner);
            LOGGER.error("Invalid date entered");
        }
        return String.valueOf(localDate.toEpochDay() * 24 * 60 * 60 * 1000);
    }

}
