package com.epam.radziievskyi.shop.service;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    void showAllProducts ();

    Vehicle getProductById (String productId);

    List<Vehicle> getAllProductsList ();

    void addProduct (AbstractMethodTemplate abstractMethodTemplate) throws IOException;

}
