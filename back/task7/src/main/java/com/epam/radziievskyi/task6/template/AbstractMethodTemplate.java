package com.epam.radziievskyi.task6.template;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class AbstractMethodTemplate {

    private static final Logger LOGGER = Logger.getLogger(AbstractMethodTemplate.class);

    protected InputStrategy inputStrategy;
    protected Vehicle vehicle;
    protected ResourceBundle bundle;

    public AbstractMethodTemplate(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    protected abstract void setUpVehicle();

    public Vehicle getVehicle() throws IOException {
        setUpVehicle();
        inputForVehicle(bundle);
        otherInputForVehicle();
        LOGGER.debug("Template for custom Vehicle was generated");
        return vehicle;
    }

    protected abstract void otherInputForVehicle() throws IOException;

    protected void inputForVehicle(ResourceBundle bundle) {
        vehicle.setNameOfProduct(inputStrategy.getString(bundle.getString("setNameOfProduct"), new Scanner(System.in)));
        vehicle.setBrand(inputStrategy.getString(bundle.getString("setBrand"), new Scanner(System.in)));
        vehicle.setPassengers(inputStrategy.getInteger(bundle.getString("setPassengers"), new Scanner(System.in)));
        vehicle.setMaxSpeed(inputStrategy.getInteger(bundle.getString("setMaxSpeed"), new Scanner(System.in)));
        vehicle.setPrice(inputStrategy.getInteger(bundle.getString("setPrice"), new Scanner(System.in)));
        vehicle.setManufacturerCountry(inputStrategy.getString(bundle.getString("setManufacturerCountry"),
                new Scanner(System.in)));
        vehicle.setYear(inputStrategy.getInteger(bundle.getString("setYear"), new Scanner(System.in)));
        vehicle.setHorsePower(inputStrategy.getInteger(bundle.getString("setHorsePower"), new Scanner(System.in)));
        vehicle.setModel(inputStrategy.getString(bundle.getString("setModel"), new Scanner(System.in)));
        LOGGER.info("Vehicle was created by customer");
    }

}
