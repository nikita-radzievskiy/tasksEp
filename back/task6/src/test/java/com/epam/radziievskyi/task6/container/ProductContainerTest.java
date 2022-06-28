package com.epam.radziievskyi.task6.container;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProductContainerTest {

    @Mock
    List<Vehicle> allProducts;
    @InjectMocks
    ProductContainer productContainer;

    private final ProductContainer productContainerMock = mock(ProductContainer.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productContainer = new ProductContainer(allProducts);
    }

    @Test
    void shouldReturnListWithElementsWhenCallsMethodGetAllProduct() {
        //given
        List<Vehicle> vehicles = Arrays.asList(
                new ElectroCar("Electro Car", "USA", "Tesla",
                        "Model X", 4, 2019, 250, 150, 20000,
                        4, "150000V"),
                new ElectroCar("Electro Car", "Germany", "BMW", "I3",
                        4, 2017, 220, 150, 16000, 4, "19000V"));

        //when
        given(productContainerMock.getAllProducts()).willReturn(vehicles);

        //then
        assertThat(productContainerMock.getAllProducts()).isEqualTo(vehicles);
    }

    @Test
    void shouldAddProductWhenCalledMethodAddProduct() {
        //given
        Vehicle vehicle = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V");

        //when
        productContainerMock.addProduct(vehicle);

        //then
        verify(productContainerMock).addProduct(vehicle);
    }

}
