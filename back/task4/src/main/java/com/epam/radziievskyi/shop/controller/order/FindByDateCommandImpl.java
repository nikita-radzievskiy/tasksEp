package com.epam.radziievskyi.shop.controller.order;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.utils.DateUtil;
import com.epam.radziievskyi.shop.service.OrderService;
import org.apache.log4j.Logger;

import java.text.ParseException;

public class FindByDateCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(FindByDateCommandImpl.class);

    private final OrderService orderService;

    public FindByDateCommandImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() throws ParseException {
        System.out.println("Enter start date and end date\n");
        DateUtil startDate = new DateUtil();
        DateUtil endDate = new DateUtil();
        try {
            orderService.findBetweenDates(startDate.formatDate(), endDate.formatDate());
        } catch (ParseException e) {
            System.out.println("Incorrect date format" + "\n" + "Please, enter date in format dd.MM.yyyy");
            LOGGER.error("Incorrect date format", e);
        }
        LOGGER.debug("Method execute() in class FindByDateCommandImpl was called");
    }

}
