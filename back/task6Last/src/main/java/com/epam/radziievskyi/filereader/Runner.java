package com.epam.radziievskyi.filereader;

import com.epam.radziievskyi.filereader.chainofrespon.RunnerForValidator;
import com.epam.radziievskyi.filereader.readlinebyline.RunnerForTxtReader;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

    private final static Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main (String[] args) {
        try {
            run();
        } catch (InputMismatchException exception) {
            LOGGER.error("Input mismatch exception", exception);
            System.out.println("Wrong input");
        }

    }

    private static void run () {
        RunnerForTxtReader txtReader = new RunnerForTxtReader();
        RunnerForValidator chain = new RunnerForValidator();
        System.out.println("\nPress 1 to run task5 part1" + "\nPress 2 to run task5 part2" +
                "\nPress 0 to exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Read txt file line by line\n");
                txtReader.run();
                LOGGER.info("File read");
                break;
            case 2:
                System.out.println("Chain of responsibility\n");
                chain.run();
                LOGGER.info("Chain of responsibility");
                break;
            default:
                LOGGER.error("Wrong input");
                System.out.println("Wrong input");
        }
    }

}
