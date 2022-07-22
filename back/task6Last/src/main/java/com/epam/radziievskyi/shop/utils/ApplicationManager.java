package com.epam.radziievskyi.shop.utils;

import com.epam.radziievskyi.shop.ApplicationContext;
import com.epam.radziievskyi.shop.container.CommandContainer;
import com.epam.radziievskyi.task6.strategy.InputStrategy;
import com.epam.radziievskyi.task6.strategy.impl.ConsoleInputStrategyImpl;
import com.epam.radziievskyi.task6.strategy.impl.RandomInputStrategyImpl;
import com.epam.radziievskyi.task6.utils.StrategyInitializationUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationManager {

    private final static Logger LOGGER = Logger.getLogger(ApplicationManager.class);

    private final StrategyInitializationUtil initialization = new StrategyInitializationUtil();
    private InputStrategy strategyInterface = null;


    public ApplicationManager () {
    }

    public void run () throws ParseException, IOException {
        LOGGER.info("Application started");
        initialization.deserializeFile();
        initialization.headerWriter();
        Scanner scannerForStrategy = new Scanner(System.in);

        int strategyChoice = getStrategyChoice(scannerForStrategy);
        chooserOfStrategy(scannerForStrategy, strategyChoice);

        ApplicationContext applicationContext = new ApplicationContext(strategyInterface);
        CommandContainer commandContainer = new CommandContainer(applicationContext);

        applicationContext.getProductDAO().addProductByDeserializedFile();

        Scanner scannerForMenu = new Scanner(System.in);
        while (applicationContext.getExitMarker().isExitFlag()) {

            System.out.println("---------------------------");
            System.out.println("Please enter the command\n" +
                    ("---------------------------"));
            System.out.println("CONSOLE SHOP \n" +
                    "1.store\n" +
                    "2.show cart\n" +
                    "3.add to cart\n" +
                    "4.clear cart\n" +
                    "5.remove some element from cart\n" +
                    "6.show order list\n" +
                    "7.add element to order\n" +
                    "8.clear order\n" +
                    "9.remove some element from order\n" +
                    "10.find order by the date\n" +
                    "11.find nearest and upcoming order\n" +
                    "12.find last element in order\n" +
                    "13.add product\n" +
                    "0.exit\n");

            String number = scannerForMenu.nextLine();
            commandContainer.getCommand(number).execute();
        }
        initialization.serializeFile(applicationContext.getProductService().getAllProductsList());
        LOGGER.info("Application finished and data serialized");
    }

    private int getStrategyChoice (Scanner scannerForStrategy) {
        int strategyChoice = 0;
        boolean inputInvalid = true;
        do {
            try {
                strategyChoice = scannerForStrategy.nextInt();
                inputInvalid = false;
                LOGGER.info("Input is by numbers");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please input a number only!");
                scannerForStrategy.next();
                LOGGER.error("Input is not by numbers");
            }
        } while (inputInvalid);
        return strategyChoice;
    }

    private void chooserOfStrategy (Scanner scannerForStrategy, int strategyChoice) {
        while (strategyChoice != 1 && strategyChoice != 2) {
            System.out.println("Wrong input, try again");
            strategyChoice = scannerForStrategy.nextInt();
        }
        if (strategyChoice == 1) {
            LOGGER.info("Default strategy was chosen");
            strategyInterface = new ConsoleInputStrategyImpl();
        } else if (strategyChoice == 2) {
            LOGGER.info("Custom strategy was chosen");
            strategyInterface = new RandomInputStrategyImpl();
        }
    }

}