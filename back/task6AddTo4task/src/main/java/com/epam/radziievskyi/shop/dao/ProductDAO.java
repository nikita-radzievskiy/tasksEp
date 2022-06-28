package com.epam.radziievskyi.shop.dao;

import com.epam.radziievskyi.entity.Vehicle;

import java.util.List;

public interface ProductDAO {

    Vehicle getProductByName (String name);

    List<Vehicle> getAllProducts ();

    void addProduct (Vehicle product);

    List<Vehicle> listWitProductsForSerializeTest ();

}
