package com.epam.radziievskyi.task6.template.impl;

import com.epam.radziievskyi.entity.SeaVehicle;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;
import java.util.Scanner;

public class SeaVehicleTemplate extends AbstractMethodTemplate {

    private static final Logger LOGGER = Logger.getLogger(SeaVehicleTemplate.class);

    private final ResourceBundle bundle;

    private final Scanner scanner = new Scanner(System.in);

    public SeaVehicleTemplate(InputStrategy strategy, ResourceBundle bundle) {
        super(bundle);
        this.inputStrategy = strategy;
        this.bundle = bundle;
    }

    @Override
    protected void setUpVehicle() {
        this.vehicle = new SeaVehicle();
        LOGGER.debug("SeaVehicle was created");
    }

    @Override
    protected void otherInputForVehicle() {
        ((SeaVehicle) vehicle).setMaterialOfShip(inputStrategy.getString(bundle.getString("setMaterialOfShip"), scanner));
        LOGGER.info("SeaVehicle was created by customer");
    }

}
