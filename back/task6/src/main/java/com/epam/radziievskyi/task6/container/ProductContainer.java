package com.epam.radziievskyi.task6.container;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ProductContainer {

    private List<Vehicle> allProducts = new ArrayList<>();

    public ProductContainer(List<Vehicle> allProducts) {
        this.allProducts = allProducts;
    }

    public ProductContainer() {
    }

    public List<Vehicle> listWitProducts() {
        allProducts.add(new ElectroCar("Electro Car", "USA", "Tesla", "Model X", 4, 2019, 250, 150, 20000, 4, "150000V"));
        allProducts.add(new ElectroCar("Electro Car", "Germany", "BMW", "I3", 4, 2017, 220, 150, 16000, 4, "19000V"));
        allProducts.add(new ElectroCar("Electro Car", "USA", "Tesla", "Model S", 4, 2018, 220, 190, 20000, 4, "150000V"));
        return allProducts;
    }

    public void addProduct(Vehicle product) {
        allProducts.add(product);
    }

    public List<Vehicle> getAllProducts() {
        return allProducts;
    }

}
