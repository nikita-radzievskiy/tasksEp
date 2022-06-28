package com.epam.radziievskyi.shop.controller.product;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.ProductService;
import org.apache.log4j.Logger;

public class ShowAllProductsCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(ShowAllProductsCommandImpl.class);

    private ProductService productService;

    public ShowAllProductsCommandImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        productService.showAllProducts();
        LOGGER.info("Method execute() in class ShowAllProductsCommandImpl was called");
    }
}
