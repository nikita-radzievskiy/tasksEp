package com.epam.radziievskyi.shop.controller.order;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.OrderService;
import com.epam.radziievskyi.shop.utils.DateUtil;
import org.apache.log4j.Logger;

import java.text.ParseException;

public class FindNearestAndUpcomingOrderCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(FindNearestAndUpcomingOrderCommandImpl.class);

    private final OrderService orderService;

    public FindNearestAndUpcomingOrderCommandImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() throws ParseException {
        System.out.println("Enter date\n");
        DateUtil closerDate = new DateUtil();
        try {
            orderService.findNearestAndUpcomingOrder(closerDate.formatDate());
        } catch (ParseException e) {
            System.out.println("Incorrect date format" + "\n" + "Please, enter date in format dd.MM.yyyy");
            LOGGER.error("Incorrect date format", e);
        }
        LOGGER.debug("Method execute() in class FindNearestAndUpcomingOrderCommandImpl was called");
    }

}
