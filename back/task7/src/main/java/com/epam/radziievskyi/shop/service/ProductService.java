package com.epam.radziievskyi.shop.service;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public interface ProductService {

    void showAllProducts();

    Vehicle getProductById(String productId);

    List<Vehicle> getAllProductsList();

    void addProduct(AbstractMethodTemplate abstractMethodTemplate) throws IOException;

    void addProductReflection(AbstractMethodTemplate abstractMethodTemplate, ResourceBundle resourceBundle) throws IOException;

}
