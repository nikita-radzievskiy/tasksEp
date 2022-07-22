package com.epam.radziievskyi.shop.controller.cart;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.CartService;
import org.apache.log4j.Logger;

public class ClearCartCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(ClearCartCommandImpl.class);

    private final CartService cartService;

    public ClearCartCommandImpl (CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute () {
        cartService.clearCart();
        System.out.println("Cart was cleaned");
        LOGGER.debug("Method execute() in class ClearCartCommandImpl was called");
    }

}
