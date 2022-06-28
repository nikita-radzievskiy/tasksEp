package com.epam.radziievskyi.shop.service;

import com.epam.radziievskyi.entity.Vehicle;

import java.util.List;

public interface ProductService {

    void showAllProducts();

    Vehicle getProductById(String productId);

    List<Vehicle> getAllProductsList();

}
