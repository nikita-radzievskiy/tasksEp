package com.epam.radziievskyi.filereader.chainofrespon.filters;

import com.epam.radziievskyi.filereader.chainofrespon.chain.Filter;
import org.apache.log4j.Logger;

import java.io.File;

public class FindByFormatFilter extends Filter {

    private final static Logger LOGGER = Logger.getLogger(FindByFormatFilter.class);


    private String extension;

    public FindByFormatFilter(Filter filter) {
        super(filter);
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean check(File file) {
        LOGGER.info("Checking file " + file.getName() + " for format");
        return file.getName().endsWith(extension) && checkNext(file);
    }

}



