package com.epam.radziievskyi.filereader.chainofrespon.filters;

import com.epam.radziievskyi.filereader.chainofrespon.chain.Filter;
import org.apache.log4j.Logger;

import java.io.File;

public class FindByDateFilter extends Filter {

    private final static Logger LOGGER = Logger.getLogger(FindByDateFilter.class);

    private String firstDate;
    private String secondDate;

    public FindByDateFilter(Filter filter) {
        super(filter);
    }

    public void setFirstDate(String minTime) {
        this.firstDate = minTime;
    }

    public void setSecondDate(String maxTime) {
        this.secondDate = maxTime;
    }

    @Override
    public boolean check(File file) {
        LOGGER.info("Checking file " + file.getName() + " for date");
        return file.lastModified() >= Long.parseLong(firstDate) && file.lastModified() <= Long.parseLong(secondDate) && checkNext(file);
    }

}


