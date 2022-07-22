package com.epam.radziievskyi.shop.controller.product;

import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.service.ProductService;
import com.epam.radziievskyi.shop.utils.AdderProductToListUtil;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;

public class AddProductCommandImpl implements Command {

    private final static Logger LOGGER = Logger.getLogger(AddProductCommandImpl.class);

    private final ProductService productService;

    InputStrategy inputStrategy;

    public AddProductCommandImpl(ProductService productService, InputStrategy inputStrategy) {
        this.productService = productService;
        this.inputStrategy = inputStrategy;
    }

    @Override
    public void execute() throws IOException, ParseException {
        AdderProductToListUtil adderProductToListUtil = new AdderProductToListUtil(inputStrategy);
        adderProductToListUtil.printMenu();
        LOGGER.info("Created map of vehicles");
        productService.addProduct(adderProductToListUtil.checkForMap());
    }

}