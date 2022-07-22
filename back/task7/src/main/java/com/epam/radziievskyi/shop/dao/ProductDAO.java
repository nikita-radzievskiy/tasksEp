package com.epam.radziievskyi.shop.dao;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;

import java.io.IOException;
import java.util.List;

public interface ProductDAO {

    Vehicle getProductByName(String name);

    List<Vehicle> getAllProducts();

    void addProduct(AbstractMethodTemplate template) throws IOException;

    List<Vehicle> listWitProductsForSerializeTest();

    void addProductReflection(AbstractMethodTemplate abstractMethodTemplate) throws IOException;

}
