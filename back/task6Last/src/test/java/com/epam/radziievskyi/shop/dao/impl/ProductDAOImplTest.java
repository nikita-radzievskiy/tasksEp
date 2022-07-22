package com.epam.radziievskyi.shop.dao.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductDAOImplTest {

    @InjectMocks
    ProductDAOImpl productDAOImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productDAOImpl = new ProductDAOImpl();
    }

    @Test
    public void shouldReturnChosenElementWhenCallsMethodGetProductByName() {
        //given
        new ProductDAOImpl().getProductByName("Model X");

        //then
        assertEquals(new ElectroCar("Electro Car", "USA", "Tesla",
                        "Model X", 4, 2019, 250, 150, 20000,
                        4, "150000V")
                , productDAOImpl.getProductByName("Model X"));
    }

}
