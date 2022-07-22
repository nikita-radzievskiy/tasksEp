package com.epam.radziievskyi.shop.utils;

import com.epam.radziievskyi.shop.controller.product.AddProductCommandImpl;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import com.epam.radziievskyi.task6.template.impl.BenzoCarTemplate;
import com.epam.radziievskyi.task6.template.impl.ElectroCarTemplate;
import com.epam.radziievskyi.task6.template.impl.SeaVehicleTemplate;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AdderProductToListUtil {

    private final static Logger LOGGER = Logger.getLogger(AddProductCommandImpl.class);
    private static final String HEADER_FOR_MENU = "Enter the type of the product: ";
    private static final String ELECTRO_CAR = "1. ElectroCar";
    private static final String BENZO_CAR = "2. BenzoCar";
    private static final String SEA_VEHICLE = "3. SeaVehicle";
    private final InputStrategy inputStrategy;
    private ResourceBundle resourceBundle;
    private final static String RESOURCE_BUNDLE_NAME = "resource_en";

    public AdderProductToListUtil(InputStrategy inputStrategy) {
        this.inputStrategy = inputStrategy;
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME);
    }

    public void printMenu() {
        System.out.println("-----------------------------------------------------");
        System.out.println(HEADER_FOR_MENU);
        System.out.println(ELECTRO_CAR);
        System.out.println(BENZO_CAR);
        System.out.println(SEA_VEHICLE);
        System.out.println("-----------------------------------------------------");
    }

    /**
     * The method adds the product to the store by type and check input
     * by user
     *
     * @return product
     */
    public AbstractMethodTemplate checkForMap() {
        Map<String, AbstractMethodTemplate> vehicles = fillMap();
        Scanner scanner = new Scanner(System.in);
        String chooseTypeOfVehicle = scanner.next();
        while (true) {
            checkNum();
            if (vehicles.containsKey(chooseTypeOfVehicle)) {
                return vehicles.get(chooseTypeOfVehicle);
            } else {
                System.out.println("Incorrect input");
                return checkForMap();
            }
        }
    }

    /**
     * The method check correct input by user
     */
    private void checkNum() {
        while (true) {
            try {
                return;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Enter only numbers");
                LOGGER.info("Invalid input by letters");
                return;
            }
        }
    }

    private Map<String, AbstractMethodTemplate> fillMap() {
        Map<String, AbstractMethodTemplate> vehicleMap = new HashMap<>();
        vehicleMap.put("1", new ElectroCarTemplate(inputStrategy, resourceBundle));
        vehicleMap.put("2", new BenzoCarTemplate(inputStrategy, resourceBundle));
        vehicleMap.put("3", new SeaVehicleTemplate(inputStrategy, resourceBundle));
        return vehicleMap;
    }

}