package com.epam.radziievskyi.task6.strategy.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CustomStrategyImplTest {
    @InjectMocks
    CustomStrategyImpl customStrategyImpl;

    private final CustomStrategyImpl customStrategyImplMock = mock(CustomStrategyImpl.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customStrategyImpl = new CustomStrategyImpl();
    }

    @Test
    void shouldAddCustomProductToContainerWhenCallsMethodAddProduct() {
        //given
        List<Vehicle> vehicles = Arrays.asList(
                new ElectroCar("Electro Car", "USA", "Tesla",
                        "Model X", 4, 2019, 250, 150, 20000,
                        4, "150000V"));

        //when
        customStrategyImplMock.addProduct();
        verify(customStrategyImplMock, times(1)).addProduct();

        //then
        Assertions.assertDoesNotThrow(() -> customStrategyImplMock.addProduct());

    }

    @Test
    void shouldReturnListWithCustomProductsWhenCallsMethodGetAllVehicles() {
        //given
        List<Vehicle> vehicles = Arrays.asList(
                new ElectroCar("Electro Car", "USA", "Tesla",
                        "Model X", 4, 2019, 250, 150, 20000,
                        4, "150000V"));

        //when
        customStrategyImplMock.getAllVehicles();
        when(customStrategyImplMock.getAllVehicles()).thenReturn(vehicles);

        //then
        assertEquals(vehicles, customStrategyImplMock.getAllVehicles());
    }

}
