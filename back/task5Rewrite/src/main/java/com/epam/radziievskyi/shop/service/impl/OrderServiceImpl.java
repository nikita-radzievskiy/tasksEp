package com.epam.radziievskyi.shop.service.impl;

import com.epam.radziievskyi.shop.dao.impl.OrderDAOImpl;
import com.epam.radziievskyi.shop.entity.CartEntity;
import com.epam.radziievskyi.shop.service.OrderService;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private final static Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

    private OrderDAOImpl orderDao;

    public OrderServiceImpl(OrderDAOImpl orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void addProductToOrder(Date time, CartEntity cart) {
        orderDao.addProductToOrder(time, cart);
        LOGGER.debug("Method addProductToOrder was called");
    }

    @Override
    public void removeProductFromOrder(Date time, CartEntity cart) {
        orderDao.removeProductFromOrder(time, cart);
        LOGGER.debug("Method removeProductFromOrder was called");
    }

    @Override
    public void clearOrder() {
        orderDao.clearOrder();
        LOGGER.debug("Method clearOrder was called");
    }

    @Override
    public void getAllOrder() {
        orderDao.getAllOrder();
        LOGGER.debug("Method getAllOrder was called");
    }

    @Override
    public void getTotalPrice() {
        System.out.println("\nTotal price: " + orderDao.getTotalPrice());
        LOGGER.debug("Method getTotalPrice was called");
    }

    @Override
    public void findBetweenDates(Date start, Date end) {
        orderDao.findBetweenDates(start, end);
        LOGGER.debug("Method findBetweenDates was called");
    }

    @Override
    public void findNearestAndUpcomingOrder(Date date) {
        orderDao.findNearestAndUpcomingOrder(date);
        LOGGER.debug("Method findNearestAndUpcomingOrder was called");
    }

    @Override
    public void getLastElements(int number) {
        orderDao.getLastElements(number);
        LOGGER.debug("Method getLastElements was called");
    }

    @Override
    public Map<Date, CartEntity> getOrder() {
        return orderDao.getOrder();
    }

}



