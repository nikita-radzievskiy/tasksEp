package com.epam.radziievskyi.shop.dao.impl;

import com.epam.radziievskyi.shop.dao.OrderDAO;
import com.epam.radziievskyi.shop.entity.CartEntity;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.TreeMap;

public class OrderDAOImpl implements OrderDAO {

    private final static Logger LOGGER = Logger.getLogger(OrderDAOImpl.class);

    private TreeMap<Date, CartEntity> order;


    public OrderDAOImpl(Map<Date, CartEntity> cart) {
        this.order = new TreeMap<>();
    }

    @Override
    public void removeProductFromOrder(Date time, CartEntity cart) {
        if (order.containsKey(time)) {
            order.remove(time, cart);
            System.out.println("Product removed from order");
            LOGGER.debug("Product removed from order");
        } else {
            System.out.println("Product not found in order");
            LOGGER.error("Product not found in order");
        }
    }

    @Override
    public Map<Date, CartEntity> getAllOrder() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        for (Map.Entry<Date, CartEntity> entry : order.entrySet()) {
            System.out.println(dateFormat.format(entry.getKey()) + " " + entry.getValue().getCart());

            if (entry.getValue() == null || entry.getValue().isEmpty()) {
                System.out.println("Your order is empty");
            }
        }
        LOGGER.error("Order is empty");
        return null;
    }

    @Override
    public void addProductToOrder(Date time, CartEntity cart) {
        if (!order.containsKey(time) || order.get(time) == null || !order.get(time).isEmpty()) {
            if (!cart.isEmpty()) {
                order.put(time, cart);
                System.out.println("Product added to order");
            }
        } else {
            LOGGER.error("Product not added to order");
            System.out.println("Product already in order or cart is empty");
        }
        LOGGER.debug("Product added to order");
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Date key : order.keySet()) {
            for (String key1 : order.get(key).getCart().keySet()) {
                totalPrice += order.get(key).getCart().get(key1).getPrice();
                LOGGER.debug("Total price is " + totalPrice);
            }
        }
        return totalPrice;
    }

    @Override
    public void findBetweenDates(Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        order.forEach((key, value) -> {
            if (key.after(startDate) && key.before(endDate)) {
                System.out.println("\nOrder for " + dateFormat.format(startDate) + " to " + dateFormat.format(endDate) + ":");
                System.out.println(dateFormat.format(key) + " " + value.getCart());
                LOGGER.debug("Order found");
            } else {
                System.out.println("No such date");
                LOGGER.error("No such date");
            }
        });
    }

    @Override
    public void findNearestAndUpcomingOrder(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Map.Entry<Date, CartEntity> nearestOrder = order.floorEntry(date);
        Map.Entry<Date, CartEntity> upcomingOrder = order.ceilingEntry(date);
        if (nearestOrder != null) {
            System.out.println("Nearest order: " + dateFormat.format(nearestOrder.getKey()) + " " + nearestOrder.getValue().getCart());
            LOGGER.debug("Nearest order found");

        } else {
            System.out.println("No nearest order");
            LOGGER.error("No nearest order");
        }
        if (upcomingOrder != null) {
            System.out.println("Upcoming order: " + dateFormat.format(upcomingOrder.getKey()) + " " + upcomingOrder.getValue().getCart());
            LOGGER.debug("Upcoming order found");
        } else {
            System.out.println("No upcoming order");

        }
        LOGGER.debug("Nearest and upcoming order found");
    }

    @Override
    public void clearOrder() {
        order.clear();
        LOGGER.info("Order cleared");
    }

    @Override
    public boolean orderIsEmpty() {
        LOGGER.info("Order is empty");
        return order.isEmpty();
    }

    @Override
    public void getLastElements(int elements) {
        System.out.println("Last " + elements + " elements: ");
        int i = 0;
        try {
            for (Date key : order.keySet()) {
                if (i < elements) {
                    System.out.println(key + " " + order.get(key));
                    i++;
                    LOGGER.debug("Last elements are printed");
                } else {
                    break;
                }
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Wrong input");
            LOGGER.error("Wrong input");
        }
    }

    @Override
    public Map<Date, CartEntity> getOrder() {
        return order;
    }

}


