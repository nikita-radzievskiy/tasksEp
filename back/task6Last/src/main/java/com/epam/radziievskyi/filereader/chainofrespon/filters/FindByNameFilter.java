package com.epam.radziievskyi.filereader.chainofrespon.filters;

import com.epam.radziievskyi.filereader.chainofrespon.chain.Filter;
import org.apache.log4j.Logger;

import java.io.File;

public class FindByNameFilter extends Filter {

    private final static Logger LOGGER = Logger.getLogger(FindByNameFilter.class);


    private String fileName;

    public FindByNameFilter (Filter filter) {
        super(filter);
    }

    public void setFileName (String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean check (File file) {
        LOGGER.info("Checking file " + file.getName() + " for name");
        return file.getName().contains(fileName) && checkNext(file);
    }

}