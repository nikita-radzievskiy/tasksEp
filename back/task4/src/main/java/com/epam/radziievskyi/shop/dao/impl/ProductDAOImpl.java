package com.epam.radziievskyi.shop.dao.impl;

import com.epam.radziievskyi.entity.BenzoCar;
import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.shop.dao.ProductDAO;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private final List<Vehicle> allProducts = new ArrayList<>();

    public ProductDAOImpl() {
        allProducts.add(new ElectroCar("Electro Car", "USA", "Tesla", "Model X", 4, 2019, 250, 150, 20000, 4, "150000V"));
        allProducts.add(new ElectroCar("Electro Car", "Germany", "BMW", "I3", 4, 2017, 220, 150, 16000, 4, "19000V"));
        allProducts.add(new ElectroCar("Electro Car", "USA", "Tesla", "Model S", 4, 2018, 220, 190, 20000, 4, "150000V"));
        allProducts.add(new ElectroCar("Electro Car", "USA", "Tesla", "Model Y", 5, 2021, 250, 200, 29000, 4, "190000V"));
        allProducts.add(new BenzoCar("Benzo Car", "USA", "BMW", "X6", 4, 2021, 250, 150, 69000, 4, "200L"));
        allProducts.add(new BenzoCar("Benzo Car", "USA", "BMW", "X5", 4, 2019, 250, 150, 20000, 4, "200L"));
        allProducts.add(new BenzoCar("BenzoCar", "Germany", "Volkswagen", "Getta", 4, 2020, 250, 150, 36000, 4, "100L"));
        allProducts.add(new ElectroCar("Electro Bike", "USA", "Harley Davidson", "TH3", 2, 2020, 200, 150, 22000, 2, "2300V"));
    }

    @Override
    public List<Vehicle> getAllProducts() {
        return allProducts;
    }

    @Override
    public Vehicle getProductByName(String name) {
        Vehicle vehicle = null;
        for (Vehicle product : allProducts) {
            if (product.getModel().equals(name)) {
                vehicle = product;
                break;
            }
        }
        return vehicle;
    }

}
