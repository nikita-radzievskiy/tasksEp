package com.epam.radziievskyi.shop.service.impl;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.shop.dao.impl.ProductDAOImpl;
import com.epam.radziievskyi.shop.service.ProductService;
import org.apache.log4j.Logger;

import java.util.List;


public class ProductServiceImpl implements ProductService {

    private final static Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

    private ProductDAOImpl productDAO;

    public ProductServiceImpl(ProductDAOImpl productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void showAllProducts() {
        for (Vehicle product : productDAO.getAllProducts()) {
            System.out.println(product);
        }
        LOGGER.debug("All products were shown");
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
}
