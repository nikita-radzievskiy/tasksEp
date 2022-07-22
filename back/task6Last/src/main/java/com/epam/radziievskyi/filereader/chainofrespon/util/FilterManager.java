package com.epam.radziievskyi.filereader.chainofrespon.util;

import com.epam.radziievskyi.filereader.chainofrespon.chain.Filter;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FilterManager {

    private final static Logger LOGGER = Logger.getLogger(FilterManager.class);
    private final String DIRECTORY = "/Users/pro/Desktop/pre_prod_java_winter_2022/";
    private final Scanner scanner = new Scanner(System.in);
    private final List<File> list = new LinkedList<>();
    private Filter filter;
    private final FilterController filterController = new FilterController();

    public List<File> initialFilter (String path) {
        LOGGER.info("Initializing filters");
        filter = filterController.name(scanner, filter);
        filter = filterController.extension(scanner, filter);
        filter = filterController.date(scanner, filter);
        filter = filterController.size(scanner, filter);
        return searchInDirectory(new File(DIRECTORY + path));
    }

    public List<File> searchInDirectory (File file) {
        File[] files = file.listFiles();
        for (File searchFile : files) {
            if (searchFile.isDirectory()) {
                LOGGER.info("Searching in directory " + searchFile.getName());
                searchInDirectory(searchFile);
            } else {
                if (filter.check(searchFile)) {
                    list.add(searchFile);
                }
            }
        }
        return list;
    }

}
