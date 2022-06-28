package com.epam.radziievskyi.task6.strategy.impl;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.shop.dao.impl.ProductDAOImpl;
import com.epam.radziievskyi.shop.utils.ApplicationManager;
import com.epam.radziievskyi.task6.serializer.impl.SerializerImpl;
import com.epam.radziievskyi.task6.strategy.Strategy;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.List;

public class CustomStrategyImpl implements Strategy {

    private static final Logger LOGGER = Logger.getLogger(CustomStrategyImpl.class);

    private final SerializerImpl serializerImpl = new SerializerImpl();
    private final ProductDAOImpl productDAO = new ProductDAOImpl();


    @Override
    public void addProduct () throws ParseException {
        System.out.println("Desialization: \n");
        if (serializerImpl.deserialize() != null) {
            LOGGER.debug("File was deserialized");
            System.out.println(serializerImpl.deserialize());
        } else {
            LOGGER.debug("File was not deserialized");
        }
        System.out.println("----------------------------------------------------\n");
        new ApplicationManager().run();
    }

    public List<Vehicle> getAllVehicles () {
        return productDAO.getAllProducts();
    }

}

