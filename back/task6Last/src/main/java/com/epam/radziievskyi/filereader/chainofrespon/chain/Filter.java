package com.epam.radziievskyi.filereader.chainofrespon.chain;

import java.io.File;

public abstract class Filter {

    private final Filter filterNext;

    public Filter (Filter filterNext) {
        this.filterNext = filterNext;
    }

    public abstract boolean check (File file);

    public boolean checkNext (File file) {
        if (filterNext == null) {
            return true;
        }
        return filterNext.check(file);
    }

}
