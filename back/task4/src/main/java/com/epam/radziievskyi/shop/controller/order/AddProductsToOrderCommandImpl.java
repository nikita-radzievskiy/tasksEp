package com.epam.radziievskyi.shop.controller.order;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.dao.impl.CartDAOImpl;
import com.epam.radziievskyi.shop.dao.impl.OrderDAOImpl;
import com.epam.radziievskyi.shop.utils.DateUtil;
import com.epam.radziievskyi.shop.service.CartService;
import com.epam.radziievskyi.shop.service.OrderService;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AddProductsToOrderCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(AddProductsToOrderCommandImpl.class);

    private final OrderService orderService;
    private final OrderDAOImpl orderDao;
    private final CartService cartService;
    private final CartDAOImpl cartDAOImpl;

    public AddProductsToOrderCommandImpl(OrderService orderService, OrderDAOImpl orderDao, CartService cartService, CartDAOImpl cartDAOImpl) {
        this.orderService = orderService;
        this.orderDao = orderDao;
        this.cartService = cartService;
        this.cartDAOImpl = cartDAOImpl;
    }

    public void buy() {
        try {
            System.out.println("\nDo you want to buy? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals("y")) {
                LOGGER.debug("User want to buy");
                if (orderDao.orderIsEmpty()) {
                    LOGGER.debug("Order is empty");
                    System.out.println("Your order is empty");
                } else {
                    System.out.println("Total price of your order: " + orderDao.getTotalPrice());
                    cartDAOImpl.clearCart();
                    System.out.println("Thank you for your purchase!");
                }
            }
            if (answer.equals("n")) {
                LOGGER.debug("User don't want to buy");
                System.out.println("Thank you for your visit!");
            }
            if (!answer.equals("y") && !answer.equals("n")) {
                LOGGER.debug("User entered wrong answer");
                System.out.println("Enter y or n");
            }
        } catch (InputMismatchException exception) {
            LOGGER.warn("User entered wrong answer");
            System.out.println("Enter y or n");
        }
    }

    @Override
    public void execute() throws ParseException {
        cartService.getProductFromCart();
        DateUtil dateEntity = new DateUtil();
        try {
            orderService.addProductToOrder(dateEntity.formatDate(), cartService.getCart().copy());
        } catch (ParseException e) {
            System.out.println("Incorrect input" + "\nEnter date and time in format dd.MM.yyyy HH:mm");
        }
        buy();
        System.out.println("\nPrice of order: " + orderDao.getTotalPrice());
        LOGGER.debug("Method execute() in class AddProductsToOrderCommandImpl was called");
    }

}



