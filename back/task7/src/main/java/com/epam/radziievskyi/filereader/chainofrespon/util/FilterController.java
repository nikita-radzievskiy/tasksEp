package com.epam.radziievskyi.filereader.chainofrespon.util;

import com.epam.radziievskyi.filereader.chainofrespon.chain.Filter;
import com.epam.radziievskyi.filereader.chainofrespon.filters.FindByDateFilter;
import com.epam.radziievskyi.filereader.chainofrespon.filters.FindByFormatFilter;
import com.epam.radziievskyi.filereader.chainofrespon.filters.FindByNameFilter;
import com.epam.radziievskyi.filereader.chainofrespon.filters.FindBySizeFilter;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class FilterController {

    private final static Logger LOGGER = Logger.getLogger(FilterController.class);


    public Filter name(Scanner scanner, Filter filter) {
        System.out.println("Filter by name 0/1");
        if (Validator.isNumberValid(scanner)) {
            System.out.println("Enter file name");
            FindByNameFilter searchByName = new FindByNameFilter(filter);
            searchByName.setFileName(scanner.next());
            return searchByName;
        }
        return filter;

    }

    public Filter size(Scanner scanner, Filter filter) {
        System.out.println("Filter by size 0/1");
        if (Validator.isNumberValid(scanner)) {
            FindBySizeFilter searchBySize = new FindBySizeFilter(filter);
            System.out.println("Enter min size of file ");
            searchBySize.setSizeMin(Validator.validNumberInput(scanner));
            System.out.println("Enter max size of file ");
            searchBySize.setSizeMax(Validator.validNumberInput(scanner));
            return searchBySize;
        }
        return filter;
    }

    public Filter extension(Scanner scanner, Filter filter) {
        System.out.println("Filter by extension extension 0/1");
        if (Validator.isNumberValid(scanner)) {
            System.out.println("Enter file extension of file ");
            FindByFormatFilter searchByExtension = new FindByFormatFilter(filter);
            searchByExtension.setExtension(scanner.next());
            return searchByExtension;
        }
        return filter;
    }

    public Filter date(Scanner scanner, Filter filter) {
        System.out.println("Filter by date 0/1");
        if (Validator.isNumberValid(scanner)) {
            FindByDateFilter searchByDate = null;
            try {
                System.out.println("Enter start date in format dd.MM.yyyy");
                searchByDate = new FindByDateFilter(filter);
                searchByDate.setFirstDate(Validator.validDateInput(scanner));
                System.out.println("Enter end date in format dd.MM.yyyy");
                searchByDate.setSecondDate(Validator.validDateInput(scanner));
            } catch (NullPointerException exception) {
                System.out.println("Wrong date format");
                LOGGER.error("Wrong date format");
            }
            return searchByDate;
        }
        return filter;
    }

}
