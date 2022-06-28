package com.epam.radziievskyi.task6.strategy.impl;

import com.epam.radziievskyi.entity.SeaVehicle;
import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.adderutil.RandomAdderUtil;
import com.epam.radziievskyi.task6.container.ProductContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RandomStrategyImplTest {
    @Mock
    ProductContainer productContainer;
    @InjectMocks
    RandomAdderUtil randomAdder;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        randomAdder = new RandomAdderUtil();
    }

    @Test
    void shouldAddRandomNumbersToNameAndProductsFromContainerWhenCallsMethodAddProduct() {
        //given
        when(productContainer.listWitProducts()).thenReturn(Arrays.asList(new SeaVehicle
                ("nameOfProduct", "manufacturerCountry", "brand",
                        "model", 0, 0, 0, 0, 0d, null)));

        //when
        randomAdder.addProduct();

        //then
        assertEquals(1, randomAdder.getMap().size());
    }

    @Test
    void shouldConvertMapToListForNextSerializationWhenCallsMethodConverter() {
        //given
        List<Vehicle> vehicles = Arrays.asList(
                new SeaVehicle("nameOfProduct", "manufacturerCountry",
                        "brand", "model", 0, 0, 0, 0,
                        0d, null));

        //when
        randomAdder.converterToList();
        when(productContainer.listWitProducts()).thenReturn(vehicles);

        //then
        assertEquals(1, randomAdder.getMap().size());
    }

}
