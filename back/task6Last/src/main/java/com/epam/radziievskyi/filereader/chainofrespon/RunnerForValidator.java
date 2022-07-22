package com.epam.radziievskyi.filereader.chainofrespon;

import com.epam.radziievskyi.filereader.chainofrespon.util.FilterManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class RunnerForValidator {

    private final static Logger LOGGER = Logger.getLogger(RunnerForValidator.class);

    public void run () {
        System.out.println("Press 1 to read file");
        System.out.println("Press 2 to exit");
        Scanner scannerForChoose = new Scanner(System.in);
        int choice = scannerForChoose.nextInt();
        switch (choice) {
            case 1:
                FilterManager filterManager = new FilterManager();
                System.out.println("Enter path to directory" + "\n(for example: src/main/resources/)");
                Scanner scanner = new Scanner(System.in);
                String path = scanner.nextLine();
                List<File> filteredFiles = null;
                try {
                    filteredFiles = filterManager.initialFilter(path);
                    for (File file : filteredFiles) {
                        System.out.println(file);
                    }
                } catch (NullPointerException wrongPath) {
                    System.out.println("Wrong path, please try again");
                    LOGGER.error("Wrong path");
                }
            case 2:
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Wrong input");
                LOGGER.error("Wrong input");
        }
    }

}