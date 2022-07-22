package com.epam.radziievskyi.shop.service.impl;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.shop.dao.impl.ProductDAOImpl;
import com.epam.radziievskyi.shop.service.ProductService;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;


public class ProductServiceImpl implements ProductService {

    private final static Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

    private final ProductDAOImpl productDAO;


    public ProductServiceImpl(ProductDAOImpl productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void showAllProducts() {
        productDAO.getAllProducts().forEach(System.out::println);
        LOGGER.info("All products shown");
    }

    @Override
    public Vehicle getProductById(String name) {
        for (Vehicle product : productDAO.getAllProducts()) {
            if (product.getModel().equals(name)) {
                LOGGER.info("Product " + product + " was found");
                return product;
            }
        }
        LOGGER.debug("Method getProductById() was called with wrong name");
        return null;
    }

    @Override
    public List<Vehicle> getAllProductsList() {
        LOGGER.info("All products were returned");
        return productDAO.getAllProducts();
    }

    @Override
    public void addProduct(AbstractMethodTemplate abstractMethodTemplate) throws IOException {
        productDAO.addProduct(abstractMethodTemplate);
        LOGGER.info("Product was added");
    }

    @Override
    public void addProductReflection(AbstractMethodTemplate abstractMethodTemplate, ResourceBundle resourceBundle) throws IOException {
        productDAO.addProductReflection(abstractMethodTemplate);
        LOGGER.info("Product was added");
    }
}
