package com.epam.radziievskyi.shop.controller.order;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.OrderService;
import org.apache.log4j.Logger;

public class ClearOrderCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(ClearOrderCommandImpl.class);

    private final OrderService orderService;

    public ClearOrderCommandImpl (OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute () {
        orderService.clearOrder();
        System.out.println("Order cleared");
        LOGGER.debug("Method execute() in class ClearOrderCommandImpl was called.");
    }

}