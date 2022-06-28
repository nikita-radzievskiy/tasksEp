package com.epam.radziievskyi;

import com.epam.radziievskyi.controller.FiltersWithChainOfResponsibility;
import com.epam.radziievskyi.controller.TxtReaderClass;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        TxtReaderClass txtReaderClass = new TxtReaderClass();
        FiltersWithChainOfResponsibility filtersWithChainOfResp = new FiltersWithChainOfResponsibility();
        System.out.println("Press 1 to run task5 part1");
        System.out.println("Press 2 to run task5 part2");
        System.out.println("Press 3 to stop");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                txtReaderClass.run();
                break;
            case 2:
                filtersWithChainOfResp.run();
                break;
            case 3:
                break;
        }
    }
}
