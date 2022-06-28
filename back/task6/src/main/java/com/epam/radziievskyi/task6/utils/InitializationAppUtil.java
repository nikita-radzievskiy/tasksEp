package com.epam.radziievskyi.task6.utils;

import com.epam.radziievskyi.shop.entity.ExitMarker;
import com.epam.radziievskyi.task6.adderutil.RandomAdderUtil;
import com.epam.radziievskyi.task6.serializer.impl.SerializerImpl;
import com.epam.radziievskyi.task6.strategy.Strategy;
import com.epam.radziievskyi.task6.strategy.impl.CustomStrategyImpl;
import com.epam.radziievskyi.task6.strategy.impl.RandomStrategyImpl;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Scanner;

public class InitializationAppUtil {

    private static final Logger LOGGER = Logger.getLogger(InitializationAppUtil.class);

    private final SerializerImpl serializerImpl = new SerializerImpl();
    private final CustomStrategyImpl customStrategy = new CustomStrategyImpl();
    private final RandomStrategyImpl randomStrategy = new RandomStrategyImpl();
    private final ExitMarker exitMarker = new ExitMarker();
    private final RandomAdderUtil randomAdder = new RandomAdderUtil();

    private final Scanner scannerMenu = new Scanner(System.in);
    private final Scanner scannerChoice = new Scanner(System.in);


    public void run() {
        deserializationForRunner();
        System.out.println("Enter: 1 - for run , 0 - for exit");
        String menu = scannerMenu.nextLine();

        if (menu.equals("1")) {
            runPart();
        } else if (menu.equals("0")) {
            exitPart();
        }
    }

    private void runPart() {
        LOGGER.debug("User choose to run app");
        headerWriter();
        String choiceStrategy = scannerChoice.nextLine();
        if (!serializerImpl.checkDeserialize()) {
            LOGGER.debug("User can choose strategy");
            customStrategy.chooseStrategy(setStrategy(choiceStrategy));
        }
        exitMarker.setExitFlag(true);
        if (exitMarker.isExitFlag()) {
            checkerForStrategy(setStrategy(choiceStrategy));
            LOGGER.debug("File was serialized");
            System.out.println("Serialization is successful");
        }
    }

    private void exitPart() {
        LOGGER.debug("User choose to exit app");
        exitMarker.setExitFlag(true);
        System.out.println("Nothing saved!" + "\nGoodbye!");
    }

    private void deserializationForRunner() {
        System.out.println("Desialization: \n");
        if (serializerImpl.deserialize() != null) {
            LOGGER.debug("File was deserialized");
            System.out.println(serializerImpl.deserialize());
        } else {
            LOGGER.debug("File was not deserialized");
        }
        System.out.println("----------------------------------------------------\n");
    }

    private String setStrategy(String choiceStrategy) {
        Strategy strategyInterface;
        if (choiceStrategy.equals("1")) {
            LOGGER.debug("User choose to use custom strategy");
            strategyInterface = customStrategy;
        } else {
            LOGGER.debug("User choose to use random strategy");
            strategyInterface = randomStrategy;
        }
        return choiceStrategy;
    }

    private void headerWriter() {
        System.out.println("Choose strategy: " +
                "\n1. Custom strategy" +
                "\n2. Default strategy");
    }

    private void checkerForStrategy(String choiceStrategy) {
        if (choiceStrategy.equals("1")) {
            serializerImpl.serialize(Collections.singletonList(customStrategy.getAllVehicles()));
        }
        if (choiceStrategy.equals("2")) {
            serializerImpl.serialize(Collections.singletonList(randomAdder.converterToList()));
        }
    }

}
