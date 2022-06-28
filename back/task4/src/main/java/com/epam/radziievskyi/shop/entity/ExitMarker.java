package com.epam.radziievskyi.shop.entity;

public class ExitMarker {


    private boolean exitFlag;

    public ExitMarker(boolean exitFlag) {
        this.exitFlag = exitFlag;
    }

    public boolean isExitFlag() {
        return exitFlag;
    }

    public void setExitFlag(boolean exitFlag) {
        this.exitFlag = exitFlag;
    }

}
