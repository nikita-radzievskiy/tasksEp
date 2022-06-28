package com.epam.radziievskyi.shop.controller.product;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.ProductService;
import org.apache.log4j.Logger;

public class AddProductCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(AddProductCommandImpl.class);

    private ProductService productService;

    public AddProductCommandImpl (ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute () {
        productService.addProduct();
        LOGGER.info("Method execute() in class AddProductCommandImpl was called");
    }

}
