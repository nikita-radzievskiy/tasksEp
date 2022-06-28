package com.epam.radziievskyi.shop.utils;

import com.epam.radziievskyi.shop.ApplicationContext;
import com.epam.radziievskyi.shop.container.CommandContainer;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Scanner;

public class ApplicationManager {

    private final static Logger LOGGER = Logger.getLogger(ApplicationManager.class);

    public ApplicationManager() {
    }

    public void run() throws ParseException {
        LOGGER.info("Application started");
        ApplicationContext applicationContext = new ApplicationContext();
        CommandContainer commandContainer = new CommandContainer(applicationContext);
        Scanner sc = new Scanner(System.in);

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
                    "\n13.add product to store\n" +

                    "0.exit\n");
            String number = sc.nextLine();
            commandContainer.getCommand(number).execute();

        }
    }

}