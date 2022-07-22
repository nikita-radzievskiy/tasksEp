package com.epam.radziievskyi.filereader.readlinebyline;

import com.epam.radziievskyi.filereader.readlinebyline.util.ReaderForTxtUtil;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunnerForTxtReader {

    private final static Logger LOGGER = Logger.getLogger(RunnerForTxtReader.class);

    public void run() {
        try {
            runnerForTxtReader();
        } catch (InputMismatchException inputMismatchException) {
            LOGGER.error("Input mismatch exception", inputMismatchException);
            System.out.println("Wrong input, please try again");
        }
    }

    private void runnerForTxtReader() {
        System.out.println("Press 1 to read file");
        System.out.println("Press 2 to exit");
        Scanner scannerForChoose = new Scanner(System.in);
        int choice = scannerForChoose.nextInt();
        switch (choice) {
            case 1:
                ReaderForTxtUtil read4txt = new ReaderForTxtUtil();
                read4txt.run();
                LOGGER.info("File read");
                break;
            case 2:
                System.out.println("Goodbye");
                break;
        }
    }

}
