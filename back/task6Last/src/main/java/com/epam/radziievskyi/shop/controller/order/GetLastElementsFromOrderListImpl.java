package com.epam.radziievskyi.shop.controller.order;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.OrderService;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetLastElementsFromOrderListImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(GetLastElementsFromOrderListImpl.class);

    private final OrderService orderService;

    public GetLastElementsFromOrderListImpl (OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute () {
        try {
            System.out.println("Choose number of last elements");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            orderService.getLastElements(number);
        } catch (InputMismatchException exception) {
            System.out.println("Enter number");
            LOGGER.error("Entered wrong number");
        }
        LOGGER.debug("Method execute() in class GetLastElementsFromOrderListImpl was called");
    }

}
