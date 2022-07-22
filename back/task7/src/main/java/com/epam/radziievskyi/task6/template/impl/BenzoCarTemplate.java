package com.epam.radziievskyi.task6.template.impl;

import com.epam.radziievskyi.entity.BenzoCar;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BenzoCarTemplate extends AbstractMethodTemplate {

    private static final Logger LOGGER = Logger.getLogger(BenzoCarTemplate.class);

    private final ResourceBundle bundle;

    private final Scanner scanner = new Scanner(System.in);

    public BenzoCarTemplate(InputStrategy inputStrategy, ResourceBundle bundle) {
        super(bundle);
        this.inputStrategy = inputStrategy;
        this.bundle = bundle;
    }


    @Override
    protected void setUpVehicle() {
        this.vehicle = new BenzoCar();
        LOGGER.debug("BenzoCar was created");
    }

    @Override
    protected void otherInputForVehicle() throws IOException {
        ((BenzoCar) vehicle).setWheels(inputStrategy.getInteger(bundle.getString("setWheels"), scanner));
        ((BenzoCar) vehicle).setFuelCapacity(inputStrategy.getString(bundle.getString("setFuelCapacity"), scanner));
        LOGGER.info("BenzoCar was created by customer");
    }

}
