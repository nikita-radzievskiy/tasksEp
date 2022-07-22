package com.epam.radziievskyi.shop.dao.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDAOImplAdderProductToListUtil{

    @InjectMocks
    ProductDAOImpl productDAOImpl;

    ResourceBundle resourceBundle;

    @Before
    public void setUp () {
        MockitoAnnotations.initMocks(this);
        resourceBundle = ResourceBundle.getBundle("resource");
        productDAOImpl = new ProductDAOImpl();
    }

    @Test
    public void shouldReturnChosenElementWhenCallsMethodGetProductByName () {
        //given
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        productDAOImpl.listWitProductsForSerializeTest();
        //when
        ElectroCar electroCar = (ElectroCar) productDAOImpl.getProductByName("Model X");
        //then
        assertEquals("Model X", electroCar.getModel());
    }

}
