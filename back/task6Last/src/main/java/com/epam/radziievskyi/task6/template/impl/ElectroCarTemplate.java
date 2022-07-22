package com.epam.radziievskyi.task6.template.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.task6.strategy.InputStrategy;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class ElectroCarTemplate extends AbstractMethodTemplate {

    private static final Logger LOGGER = Logger.getLogger(ElectroCarTemplate.class);

    public ElectroCarTemplate (InputStrategy strategy) {
        this.inputStrategy = strategy;
    }

    @Override
    protected void setUpVehicle () {
        this.vehicle = new ElectroCar();
        LOGGER.debug("ElectroCar was created");
    }

    @Override
    protected void otherInputForVehicle () throws IOException {
        ((ElectroCar) vehicle).setWheels(inputStrategy.getInteger("Enter wheels: ", new Scanner(System.in)));
        ((ElectroCar) vehicle).setBatteryCapacity(inputStrategy.getString("Enter battery capacity: ", new Scanner(System.in)));
        LOGGER.info("ElectroCar was created by customer");
    }

}
