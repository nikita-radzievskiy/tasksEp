package com.epam.radziievskyi.filereader.chainofrespon.filters;

import com.epam.radziievskyi.filereader.chainofrespon.chain.Filter;
import org.apache.log4j.Logger;

import java.io.File;

public class FindBySizeFilter extends Filter {

    private final static Logger LOGGER = Logger.getLogger(FindBySizeFilter.class);

    private long sizeMin;
    private long sizeMax;

    public FindBySizeFilter(Filter filter) {
        super(filter);
    }

    public void setSizeMin(long sizeMin) {
        this.sizeMin = sizeMin;
    }

    public void setSizeMax(long sizeMax) {
        this.sizeMax = sizeMax;
    }

    @Override
    public boolean check(File file) {
        LOGGER.info("Checking file " + file.getName() + " for size");
        return file.length() >= sizeMin && file.length() <= sizeMax && checkNext(file);
    }

}
