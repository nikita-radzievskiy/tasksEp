package com.epam.radziievskyi.task6.template.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ElectroCarTemplate extends AbstractMethodTemplate {

    private static final Logger LOGGER = Logger.getLogger(ElectroCarTemplate.class);

    private final ResourceBundle bundle;

    public ElectroCarTemplate(InputStrategy strategy, ResourceBundle bundle) {
        super(bundle);
        this.inputStrategy = strategy;
        this.bundle = bundle;
    }

    @Override
    protected void setUpVehicle() {
        this.vehicle = new ElectroCar();
        LOGGER.debug("ElectroCar was created");
    }

    @Override
    protected void otherInputForVehicle() throws IOException {
        ((ElectroCar) vehicle).setWheels(inputStrategy.getInteger(bundle.getString("setWheels"), new Scanner(System.in)));
        ((ElectroCar) vehicle).setBatteryCapacity(inputStrategy.getString(bundle.getString("setBatteryCapacity"), new Scanner(System.in)));
        LOGGER.info("ElectroCar was created by customer");
    }

}
