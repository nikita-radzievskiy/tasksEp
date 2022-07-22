package com.epam.radziievskyi.shop.controller.product;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.ProductService;
import com.epam.radziievskyi.task6.strategy.InputStrategy;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import com.epam.radziievskyi.task6.template.impl.BenzoCarTemplate;
import com.epam.radziievskyi.task6.template.impl.ElectroCarTemplate;
import com.epam.radziievskyi.task6.template.impl.SeaVehicleTemplate;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class AddProductCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(AddProductCommandImpl.class);
    InputStrategy inputStrategy;
    private final ProductService productService;

    public AddProductCommandImpl (ProductService productService, InputStrategy inputStrategy) {
        this.productService = productService;
        this.inputStrategy = inputStrategy;
    }

    @Override
    public void execute () throws IOException, ParseException {
        AbstractMethodTemplate abstractMethodTemplate;
        System.out.println("-----------------------------------------------------");
        System.out.println("Enter the type of the product: ");
        System.out.println("1. Electro Car");
        System.out.println("2. Benzo Car");
        System.out.println("3. Sea Vehicle");
        System.out.println("-----------------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        Map<Integer, AbstractMethodTemplate> vehicleMap = new HashMap<>();
        vehicleMap.put(1, new ElectroCarTemplate(inputStrategy));
        vehicleMap.put(2, new BenzoCarTemplate(inputStrategy));
        vehicleMap.put(3, new SeaVehicleTemplate(inputStrategy));
        LOGGER.info("Created map of vehicles");

        int strategyChoice = 0;
        boolean inputInvalid = true;
        do {
            try {
                strategyChoice = scanner.nextInt();
                if (strategyChoice > 0 && strategyChoice < 4) {
                    inputInvalid = false;
                } else {
                    System.out.println("Invalid input");
                    LOGGER.info("Invalid input by numbers");
                }
                inputInvalid = false;
            } catch (InputMismatchException ime) {
                LOGGER.error("Input is not by letter");
                System.out.println("Please input a number only!");
                scanner.next();
            }
        } while (inputInvalid || strategyChoice != 1 && strategyChoice != 2 && strategyChoice != 3);

        if (vehicleMap.containsKey(strategyChoice)) {
            abstractMethodTemplate = vehicleMap.get(strategyChoice);
            productService.addProduct(abstractMethodTemplate);
            LOGGER.info("Product added by strategy");
        } else {
            System.out.println("Something went wrong");
        }
    }

}
