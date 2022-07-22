package com.epam.radziievskyi.shop.controller.cart;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.dao.impl.CartDAOImpl;
import com.epam.radziievskyi.shop.service.CartService;
import org.apache.log4j.Logger;

public class ShowCartCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(ShowCartCommandImpl.class);

    private final CartService cartService;
    private final CartDAOImpl cartDAO;

    public ShowCartCommandImpl(CartService cartService, CartDAOImpl cartDAO) {
        this.cartService = cartService;
        this.cartDAO = cartDAO;
    }

    @Override
    public void execute() {
        if (cartDAO.getCart().isEmpty()) {
            System.out.println("Cart is empty");
            LOGGER.error("Cart is empty");
        } else {
            cartService.getProductFromCart();
            LOGGER.debug("Method execute() in class ShowCartCommandImpl was called");
        }
    }

}
