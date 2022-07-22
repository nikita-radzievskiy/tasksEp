package com.epam.radziievskyi.task7_2.proxy;

import com.epam.radziievskyi.task7_2.entity.impl.Tesla;
import com.epam.radziievskyi.task7_2.entity.VehicleInterface;
import com.epam.radziievskyi.task6.exception.UnModException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnmodifableProxyAdderProductToListUtil{
    private static final String NAME_OF_PRODUCT = "Electro Car";
    private static final String COUNTRY = "USA";
    private static final String BRAND = "Tesla";
    private static final String MODEL = "Model S";
    private static final int PASSENGER_CAPACITY = 5;
    private static final int YEAR = 2020;
    private static final int MAX_SPEED = 250;
    private static final int HORSEPOWER = 500;
    private static final int PRICE = 20000;
    private static final int WHEEL_SIZE = 4;
    private static final String BATTERY_CAPACITY = "100";
    private static final String INCORRECT_NAME = "qwertty";
    private FactoryProxy factoryProxy;

    @Before
    public void init () {
        factoryProxy = new FactoryProxy();
    }

    @Test
    public void shouldCreateProductWithFactoryMethod () {
        VehicleInterface goods = factoryProxy.createProxy(new Tesla(NAME_OF_PRODUCT, COUNTRY, BRAND, MODEL, PASSENGER_CAPACITY, YEAR, MAX_SPEED, HORSEPOWER, PRICE, WHEEL_SIZE, BATTERY_CAPACITY));
        assertEquals(NAME_OF_PRODUCT, goods.getNameOfProduct());
    }

    @Test(expected = UnModException.class)
    public void shouldCreateProductWithCreatorAndThrowException () {
        VehicleInterface goods = factoryProxy.createProxy(new Tesla(NAME_OF_PRODUCT, COUNTRY, BRAND, MODEL, PASSENGER_CAPACITY, YEAR, MAX_SPEED, HORSEPOWER, PRICE, WHEEL_SIZE, BATTERY_CAPACITY));
        goods.setNameOfProduct(INCORRECT_NAME);
    }

}