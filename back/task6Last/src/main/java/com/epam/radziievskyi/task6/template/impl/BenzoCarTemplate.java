package com.epam.radziievskyi.task6.template.impl;

import com.epam.radziievskyi.entity.BenzoCar;
import com.epam.radziievskyi.task6.strategy.InputStrategy;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class BenzoCarTemplate extends AbstractMethodTemplate {

    private static final Logger LOGGER = Logger.getLogger(BenzoCarTemplate.class);

    private final Scanner scanner = new Scanner(System.in);

    public BenzoCarTemplate (InputStrategy inputStrategy) {
        this.inputStrategy = inputStrategy;
    }


    @Override
    protected void setUpVehicle () {
        this.vehicle = new BenzoCar();
        LOGGER.debug("BenzoCar was created");
    }

    @Override
    protected void otherInputForVehicle () throws IOException {
        ((BenzoCar) vehicle).setWheels(inputStrategy.getInteger("Enter wheels: ", scanner));
        ((BenzoCar) vehicle).setFuelCapacity(inputStrategy.getString("Enter fuel capacity: ", scanner));
        LOGGER.info("BenzoCar was created by customer");
    }

}
