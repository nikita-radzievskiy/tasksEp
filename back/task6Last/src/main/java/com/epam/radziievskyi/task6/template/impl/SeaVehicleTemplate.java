package com.epam.radziievskyi.task6.template.impl;

import com.epam.radziievskyi.entity.SeaVehicle;
import com.epam.radziievskyi.task6.strategy.InputStrategy;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class SeaVehicleTemplate extends AbstractMethodTemplate {

    private static final Logger LOGGER = Logger.getLogger(SeaVehicleTemplate.class);

    private final Scanner scanner = new Scanner(System.in);

    public SeaVehicleTemplate (InputStrategy strategy) {
        this.inputStrategy = strategy;
    }

    @Override
    protected void setUpVehicle () {
        this.vehicle = new SeaVehicle();
        LOGGER.debug("SeaVehicle was created");
    }

    @Override
    protected void otherInputForVehicle () {
        ((SeaVehicle) vehicle).setMaterialOfShip(inputStrategy.getString("Enter material of ship: ", scanner));
        LOGGER.info("SeaVehicle was created by customer");
    }

}
