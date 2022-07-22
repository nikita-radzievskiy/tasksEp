package com.epam.radziievskyi.task6.template;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.strategy.InputStrategy;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public abstract class AbstractMethodTemplate {

    private static final Logger LOGGER = Logger.getLogger(AbstractMethodTemplate.class);

    protected InputStrategy inputStrategy;

    protected Vehicle vehicle;

    protected abstract void setUpVehicle ();

    public Vehicle getVehicle () throws IOException {
        setUpVehicle();
        inputForVehicle();
        otherInputForVehicle();
        LOGGER.debug("Template for custom Vehicle was generated");
        return vehicle;
    }

    protected abstract void otherInputForVehicle () throws IOException;

    protected void inputForVehicle () throws IOException {
        vehicle.setNameOfProduct(inputStrategy.getString("Enter name of product: ", new Scanner(System.in)));
        vehicle.setBrand(inputStrategy.getString("Enter brand: ", new Scanner(System.in)));
        vehicle.setPassengers(inputStrategy.getInteger("Enter passengers: ", new Scanner(System.in)));
        vehicle.setMaxSpeed(inputStrategy.getInteger("Enter max speed: ", new Scanner(System.in)));
        vehicle.setPrice(inputStrategy.getInteger("Enter price: ", new Scanner(System.in)));
        vehicle.setManufacturerCountry(inputStrategy.getString("Enter manufacturer country: ",
                new Scanner(System.in)));
        vehicle.setYear(inputStrategy.getInteger("Enter year: ", new Scanner(System.in)));
        vehicle.setHorsePower(inputStrategy.getInteger("Enter horse power: ", new Scanner(System.in)));
        vehicle.setModel(inputStrategy.getString("Enter model: ", new Scanner(System.in)));
        LOGGER.info("Vehicle was created by customer");
    }


}
