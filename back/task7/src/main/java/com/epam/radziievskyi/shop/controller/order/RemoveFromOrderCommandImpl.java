package com.epam.radziievskyi.shop.controller.order;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.dao.impl.CartDAOImpl;
import com.epam.radziievskyi.shop.dao.impl.OrderDAOImpl;
import com.epam.radziievskyi.shop.service.OrderService;
import com.epam.radziievskyi.shop.utils.DateUtil;
import org.apache.log4j.Logger;

import java.text.ParseException;

public class RemoveFromOrderCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(RemoveFromOrderCommandImpl.class);

    private final OrderService orderService;
    private final CartDAOImpl cartDao;
    private final OrderDAOImpl orderDao;

    public RemoveFromOrderCommandImpl(OrderService orderService, CartDAOImpl cartDao, OrderDAOImpl orderDa) {
        this.orderService = orderService;
        this.cartDao = cartDao;
        this.orderDao = orderDa;
    }

    @Override
    public void execute() throws ParseException {
        DateUtil dateEntity = new DateUtil();
        try {
            orderService.removeProductFromOrder(dateEntity.formatDate(), cartDao.getCart());
        } catch (ParseException e) {
            System.out.println("Incorrect date format" + "\n" + "Please, enter date in format dd.MM.yyyy");
        }
        if (orderDao.orderIsEmpty()) {
            System.out.println("Your order was cleared");
        }
        LOGGER.debug("Method execute() in class RemoveFromOrderCommandImpl was called.");
    }

}
