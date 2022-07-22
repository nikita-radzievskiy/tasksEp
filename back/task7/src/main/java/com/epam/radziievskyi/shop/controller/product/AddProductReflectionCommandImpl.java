package com.epam.radziievskyi.shop.controller.product;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.ProductService;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task7_1.reflection.ProductCreatorReflection;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ResourceBundle;

public class AddProductReflectionCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(AddProductReflectionCommandImpl.class);
    private final ProductService productService;
    private final ResourceBundle resourceBundle;
    InputStrategy inputStrategy;

    public AddProductReflectionCommandImpl(ProductService productService, InputStrategy inputStrategy, ResourceBundle resourceBundle) {
        this.productService = productService;
        this.inputStrategy = inputStrategy;
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void execute() throws IOException {
        ProductCreatorReflection productCreatorReflection = new ProductCreatorReflection(inputStrategy, resourceBundle);
        productCreatorReflection.printMenu();
        productService.addProduct(productCreatorReflection.createProduct());
        LOGGER.info("Product created");
    }

}
