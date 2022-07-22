package com.epam.radziievskyi.task7_2.proxy;

import com.epam.radziievskyi.task7_2.entity.VehicleInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class VehicleMapProxyAdderProductToListUtil{

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
    private static final String INCORRECT_NAME = "aaa";
    private static final int SET_INT = 300;

    private VehicleInterface vehicle;

    @Before
    public void init () {
        FactoryProxy factoryProxy = new FactoryProxy();
        vehicle = factoryProxy.createProxyMap();
        vehicle.setNameOfProduct(NAME_OF_PRODUCT);
        vehicle.setManufacturerCountry(COUNTRY);
        vehicle.setBrand(BRAND);
        vehicle.setModel(MODEL);
        vehicle.setPassengers(PASSENGER_CAPACITY);
        vehicle.setYear(YEAR);
        vehicle.setMaxSpeed(MAX_SPEED);
        vehicle.setHorsePower(HORSEPOWER);
        vehicle.setPrice(PRICE);
        vehicle.setWheels(WHEEL_SIZE);
        vehicle.setBatteryCapacity(BATTERY_CAPACITY);
    }

    @Test
    public void shouldGetProductNameSelectedProduct () {
        assertEquals(NAME_OF_PRODUCT, vehicle.getNameOfProduct());
    }

    @Test
    public void shouldGetCountryFromProduct () {
        assertEquals(COUNTRY, vehicle.getManufacturerCountry());
    }

    @Test
    public void shouldGetBrandFromProduct () {
        assertEquals(BRAND, vehicle.getBrand());
    }

    @Test
    public void shouldGetModelFromProduct () {
        assertEquals(MODEL, vehicle.getModel());
    }

    @Test
    public void shouldGetPassengerCapacityFromProduct () {
        assertEquals(PASSENGER_CAPACITY, vehicle.getPassengers());
    }

    @Test
    public void shouldGetYearFromProduct () {
        assertEquals(YEAR, vehicle.getYear());
    }

    @Test
    public void shouldGetMaxSpeedFromProduct () {
        assertEquals(MAX_SPEED, vehicle.getMaxSpeed());
    }

    @Test
    public void shouldGetHorsePowerFromProduct () {
        assertEquals(HORSEPOWER, vehicle.getHorsePower());
    }

    @Test
    public void shouldGetPriceFromProduct () {
        Assertions.assertEquals(PRICE, vehicle.getPrice(), 0.01);
    }

    @Test
    public void shouldGetWheelsFromProduct () {
        assertEquals(WHEEL_SIZE, vehicle.getWheels());
    }

    @Test
    public void shouldGetBatteryCapacityFromProduct () {
        assertEquals(BATTERY_CAPACITY, vehicle.getBatteryCapacity());
    }

    @Test
    public void shouldSetNameOfProduct () {
        vehicle.setNameOfProduct(INCORRECT_NAME);
        assertEquals(INCORRECT_NAME, vehicle.getNameOfProduct());
    }

    @Test
    public void shouldSetCountry () {
        vehicle.setManufacturerCountry(INCORRECT_NAME);
        assertEquals(INCORRECT_NAME, vehicle.getManufacturerCountry());
    }

    @Test
    public void shouldSetBrand () {
        vehicle.setBrand(INCORRECT_NAME);
        assertEquals(INCORRECT_NAME, vehicle.getBrand());
    }

    @Test
    public void shouldSetModel () {
        vehicle.setModel(INCORRECT_NAME);
        assertEquals(INCORRECT_NAME, vehicle.getModel());
    }

    @Test
    public void shouldSetPassengerCapacity () {
        vehicle.setPassengers(SET_INT);
        assertEquals(SET_INT, vehicle.getPassengers());
    }

    @Test
    public void shouldSetYear () {
        vehicle.setYear(SET_INT);
        assertEquals(SET_INT, vehicle.getYear());
    }

    @Test
    public void shouldSetMaxSpeed () {
        vehicle.setMaxSpeed(SET_INT);
        assertEquals(SET_INT, vehicle.getMaxSpeed());
    }

    @Test
    public void shouldSetHorsePower () {
        vehicle.setHorsePower(SET_INT);
        assertEquals(SET_INT, vehicle.getHorsePower());
    }

    @Test
    public void shouldSetPrice () {
        vehicle.setPrice(SET_INT);
        Assertions.assertEquals(SET_INT, vehicle.getPrice(), 0.01);
    }

    @Test
    public void shouldSetWheels () {
        vehicle.setWheels(SET_INT);
        assertEquals(SET_INT, vehicle.getWheels());
    }

    @Test
    public void shouldSetBatteryCapacity () {
        vehicle.setBatteryCapacity(INCORRECT_NAME);
        assertEquals(INCORRECT_NAME, vehicle.getBatteryCapacity());
    }

    @Test
    public void shouldGetDefaultPriceFromProduct () {
        VehicleInterface goods2 = new FactoryProxy().createProxyMap();
        assertEquals(0, goods2.getPrice());
    }

}