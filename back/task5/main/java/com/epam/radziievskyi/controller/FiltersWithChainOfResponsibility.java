package com.epam.radziievskyi.controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FiltersWithChainOfResponsibility {
    public void run() {
        while (true) {
            System.out.println("\n1. Filter by name" + "\n" +
                    "2. Filter by format" + "\n" + "3. Filter by size" + "\n" + "4. Filter by date" + "\n" + "0. Exit");
            try {

                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                FindByName findByName = new FindByName(input);
                findByName.action("Name", input);
                findByName.setLogger(findByName);
                FindByFormat findByFormat = new FindByFormat(input);
                findByFormat.action("Format", input);
                findByFormat.setLogger(findByFormat);
                FindBySize findBySize = new FindBySize(input);
                findBySize.action("Size", input);
                findBySize.setLogger(findBySize);
                FindByDate findByDate = new FindByDate(input);
                findByDate.action("Date", input);
                findByDate.setLogger(findByDate);
                if (input == 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
    }
}


class Filters {
    public static final int NAME_OF_FILE = 1;
    public static final int FORMAT_OF_FILE = 2;
    public static final int SIZE_OF_FILE = 3;
    public static final int DATE_OF_FILE = 4;

}

interface Logger {
    void action(String message, int chooseFilter) throws FileNotFoundException;
}

class FindByName implements Logger {
    int chooseFilter;
    Logger logger;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public FindByName(int chooseFilter) {
        this.chooseFilter = chooseFilter;
    }

    @Override
    public void action(String message, int chooseFilter) {
        if (chooseFilter == Filters.NAME_OF_FILE) {
            FindFileByNameClass findFileByNameClass = new FindFileByNameClass();
            findFileByNameClass.run();
        }
    }
}

class FindByFormat implements Logger {
    int chooseFilter;
    Logger logger;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public FindByFormat(int chooseFilter) {
        this.chooseFilter = chooseFilter;
    }

    @Override
    public void action(String message, int chooseFilter) {
        if (chooseFilter == Filters.FORMAT_OF_FILE) {
            FindFileByFormatClass findFileByFormatClass = new FindFileByFormatClass();
            findFileByFormatClass.run();
        }
    }
}

class FindBySize implements Logger {
    int chooseFilter;
    Logger logger;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public FindBySize(int chooseFilter) {
        this.chooseFilter = chooseFilter;
    }

    @Override
    public void action(String message, int chooseFilter) {
        if (chooseFilter == Filters.SIZE_OF_FILE) {
            FindBySizeClass findBySizeClass = new FindBySizeClass();
            findBySizeClass.run();
        }
    }
}

class FindByDate implements Logger {
    int chooseFilter;
    Logger logger;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public FindByDate(int chooseFilter) {
        this.chooseFilter = chooseFilter;
    }

    @Override
    public void action(String message, int chooseFilter) {
        if (chooseFilter == Filters.DATE_OF_FILE) {
            FindByDateClass findByDateClass = new FindByDateClass();
            findByDateClass.run();
        }
    }
}





