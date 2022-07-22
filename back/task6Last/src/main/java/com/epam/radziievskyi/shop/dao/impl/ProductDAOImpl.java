package com.epam.radziievskyi.shop.dao.impl;

import com.epam.radziievskyi.entity.BenzoCar;
import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.shop.dao.ProductDAO;
import com.epam.radziievskyi.task6.serializer.Serializer;
import com.epam.radziievskyi.task6.serializer.impl.SerializerImpl;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class);
    private final List<Vehicle> allProducts = new ArrayList<>();
    private final Serializer serializer = new SerializerImpl();

    public ProductDAOImpl () {
    }

    @Override
    public List<Vehicle> getAllProducts () {
        return allProducts;
    }

    @Override
    public Vehicle getProductByName (String name) {
        Vehicle vehicle = null;
        for (Vehicle product : allProducts) {
            if (product.getModel().equals(name)) {
                vehicle = product;
                break;
            }
        }
        LOGGER.info("Found product by name");
        return vehicle;
    }

    @Override
    public List<Vehicle> listWitProductsForSerializeTest () {
        allProducts.add(new ElectroCar("Electro Car", "USA", "Tesla", "Model X", 4, 2019, 250, 150, 20000, 4, "150000V"));
        allProducts.add(new ElectroCar("Electro Car", "Germany", "BMW", "I3", 4, 2017, 220, 150, 16000, 4, "19000V"));
        allProducts.add(new ElectroCar("Electro Car", "USA", "Tesla", "Model S", 4, 2018, 220, 190, 20000, 4, "150000V"));
        allProducts.add(new ElectroCar("Electro Car", "USA", "Tesla", "Model Y", 5, 2021, 250, 200, 29000, 4, "190000V"));
        allProducts.add(new BenzoCar("Benzo Car", "USA", "BMW", "X6", 4, 2021, 250, 150, 69000, 4, "200L"));
        allProducts.add(new BenzoCar("Benzo Car", "USA", "BMW", "X5", 4, 2019, 250, 150, 20000, 4, "200L"));
        allProducts.add(new BenzoCar("BenzoCar", "Germany", "Volkswagen", "Getta", 4, 2020, 250, 150, 36000, 4, "100L"));
        allProducts.add(new ElectroCar("Electro Bike", "USA", "Harley Davidson", "TH3", 2, 2020, 200, 150, 22000, 2, "2300V"));
        LOGGER.info("List of products was created");
        return allProducts;
    }

    @Override
    public void addProduct (AbstractMethodTemplate template) throws IOException {
            allProducts.add(template.getVehicle());
    }

    public void addProductByDeserializedFile () {
        if (serializer.checkDeserialize()) {
            try {
                Object deserializeVehicle = serializer.deserializeVehicle();
                allProducts.addAll((Collection<? extends Vehicle>) deserializeVehicle);
                LOGGER.info("List of products was added by deserialized file");
            } catch (Exception exception) {
                System.out.println("File is empty");
            }
        } else {
            listWitProductsForSerializeTest();
            LOGGER.info("List of products was created");
        }
    }

}
