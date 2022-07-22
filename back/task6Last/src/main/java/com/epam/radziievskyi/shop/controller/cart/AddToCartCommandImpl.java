package com.epam.radziievskyi.shop.controller.cart;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.CartService;
import com.epam.radziievskyi.shop.service.ProductService;
import org.apache.log4j.Logger;

import java.util.Scanner;


public class AddToCartCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(AddToCartCommandImpl.class);

    private final CartService cartService;
    private final ProductService productService;

    public AddToCartCommandImpl (CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @Override
    public void execute () {
        productService.showAllProducts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose model of product: ");
        String productId = scanner.nextLine();
        if (productId != null && !productId.isEmpty() && productService.getProductById(productId) != null) {
            cartService.addProduct(productId);
            LOGGER.debug("Method execute() in class AddToCartCommandImpl was called");
            System.out.println("Product was added to cart");
            LOGGER.debug("Product" + productId + "was added to cart");
        } else {
            System.out.println("No exist product with name " + productId);
            LOGGER.error("No exist product with name " + productId);
        }
    }

}
