package com.epam.radziievskyi.shop.controller.cart;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.CartService;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class RemoveFromCartCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(RemoveFromCartCommandImpl.class);
    private final CartService cartService;

    public RemoveFromCartCommandImpl(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product model for removing:");
        String productName = scanner.nextLine();
        cartService.removeProductFromCart(productName);
        LOGGER.debug("Method execute() in class RemoveFromCartCommandImpl was executed");
    }

}
