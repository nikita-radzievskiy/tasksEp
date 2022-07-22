package com.epam.radziievskyi.shop.controller.order;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.OrderService;
import org.apache.log4j.Logger;

public class ShowOrderCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(ShowOrderCommandImpl.class);

    private final OrderService orderService;

    public ShowOrderCommandImpl (OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute () {
        System.out.println("Your order:");
        orderService.getAllOrder();
        orderService.getTotalPrice();
        LOGGER.debug("Method execute() in class ShowOrderCommandImpl was called");
    }

}
