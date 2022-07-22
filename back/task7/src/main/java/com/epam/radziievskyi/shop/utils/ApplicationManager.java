package com.epam.radziievskyi.shop.utils;

import com.epam.radziievskyi.shop.ApplicationContext;
import com.epam.radziievskyi.shop.container.CommandContainer;
import com.epam.radziievskyi.task6.exception.ApplicationException;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task6.strategy.inputstrategy.impl.ConsoleInputStrategyImpl;
import com.epam.radziievskyi.task6.strategy.inputstrategy.impl.RandomInputStrategyImpl;
import com.epam.radziievskyi.task6.utils.StrategyInitializationUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ApplicationManager {

    private final static Logger LOGGER = Logger.getLogger(ApplicationManager.class);

    private final StrategyInitializationUtil initialization = new StrategyInitializationUtil();
    private InputStrategy strategyInterface = null;
    private final Map<String, InputStrategy> strategyMap = fillMap();
    Scanner scannerForStrategy = new Scanner(System.in);


    public ApplicationManager() {
    }

    public void run() throws ParseException, IOException {
        LOGGER.info("Application started");
        try {
            initialization.deserializeFile();
        } catch (ApplicationException applicationException) {
            LOGGER.error("File not found");
        }
        initialization.headerWriter();

        ApplicationContext applicationContext = new ApplicationContext(getStrategyChoice(scannerForStrategy));
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
                    "14.add product by reflection\n" +
                    "0.exit\n");

            String number = scannerForMenu.nextLine();
            commandContainer.getCommand(number).execute();
        }
        initialization.serializeFile(applicationContext.getProductService().getAllProductsList());
        LOGGER.info("Application finished and data serialized");
    }

    private InputStrategy getStrategyChoice(Scanner scanner) {
        while (true) {
            String strategy = scanner.nextLine();
            if (strategyMap.containsKey(strategy)) {
                return strategyMap.get(strategy);
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    private Map<String, InputStrategy> fillMap() {
        Map<String, InputStrategy> strategyMap = new HashMap<>();
        strategyMap.put("1", strategyInterface = new ConsoleInputStrategyImpl());
        strategyMap.put("2", strategyInterface = new RandomInputStrategyImpl());
        return strategyMap;
    }

}