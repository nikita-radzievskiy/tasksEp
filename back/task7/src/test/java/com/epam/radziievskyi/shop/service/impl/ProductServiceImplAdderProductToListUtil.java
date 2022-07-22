package com.epam.radziievskyi.shop.service.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.shop.dao.impl.ProductDAOImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ProductServiceImplAdderProductToListUtil{
    @Mock
    ProductDAOImpl productDAO;
    @InjectMocks
    ProductServiceImpl productServiceImpl;

    private ProductServiceImpl productService = mock(ProductServiceImpl.class);


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productServiceImpl = new ProductServiceImpl(productDAO);
    }

    @Test
    void shouldToShowAllProductsWhenCalledMethodGetAllProducts() {
        //given
        List<Vehicle> vehicles = Arrays.asList(
                new ElectroCar("Electro Car", "USA", "Tesla",
                        "Model X", 4, 2019, 250, 150, 20000,
                        4, "150000V"),
                new ElectroCar("Electro Car", "Germany", "BMW", "I3",
                        4, 2017, 220, 150, 16000, 4, "19000V"));

        //when
        given(productDAO.getAllProducts()).willReturn(vehicles);

        //then
        Assertions.assertEquals(vehicles, productServiceImpl.getAllProductsList());
    }


    @Test
    void shouldGetProductByNameWhenCalledMethodGetProductById() {
        //given
        new ProductServiceImpl(productDAO).getProductById("Model X");
        when(productService.getProductById("Model X")).thenReturn(new ElectroCar("Electro Car",
                "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000, 4,
                "150000V"));

        //when
        Vehicle vehicle = productService.getProductById("Model X");

        //then
        assertThat(vehicle).isEqualTo(new ElectroCar("Electro Car", "USA",
                "Tesla",
                "Model X", 4, 2019, 250, 150, 20000, 4,
                "150000V"));
    }

}
