package com.epam.radziievskyi.shop.dao.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.shop.entity.CartEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;


public class CartDAOImplTest {

    @Mock
    ProductDAOImpl productDAOImpl;

    @InjectMocks
    CartDAOImpl cartDAOImpl;

    @Spy
    private CartEntity cart = new CartEntity(new HashMap<>());


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cartDAOImpl = new CartDAOImpl(cart,productDAOImpl);
    }


    @Test
    public void shouldAddElementToCartWhenCallsAddMethod() {
        //given
        when(productDAOImpl.getProductByName(anyString())).thenReturn(new ElectroCar("Electro Car",
                "USA", "Tesla", "Model X", 4, 2019, 250,
                150, 20000, 4, "150000V"));

        //when
        cartDAOImpl.addProductToCart("Model X");

        //then
        Assert.assertEquals(1, cartDAOImpl.getCart().size());
    }

    @Test
    public void shouldReturnElementWhenCallsGetProductFromCart() {
        //given
        when(productDAOImpl.getProductByName(anyString())).thenReturn(new ElectroCar("Electro Car",
                "USA", "Tesla", "Model X", 4, 2019, 250,
                150, 20000, 4, "150000V"));

        //when
        cartDAOImpl.addProductToCart("Model X");
        Vehicle result = cartDAOImpl.getProductFromCart().getCart().get("Model X");

        //then
        Assert.assertEquals(new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000, 4,
                "150000V"), result);
    }

    @Test
    public void shouldRemoveChosenElementWhenCallsRemoveProductFromCart() {
        //given
        when(productDAOImpl.getProductByName(anyString())).thenReturn(new ElectroCar("Electro Car",
                "USA", "Tesla", "Model X", 4, 2019, 250,
                150, 20000, 4, "150000V"));

        //when
        cartDAOImpl.addProductToCart("Model X");
        cartDAOImpl.removeProductFromCart("Model X");

        //then
        Assert.assertEquals(0, cartDAOImpl.getProductFromCart().size());
    }

    @Test
    public void shouldReturnAllElementsInCartWhenCallsMethodGetCart() {
        // given
        when(productDAOImpl.getProductByName(anyString())).thenReturn(new ElectroCar("Electro Car",
                "USA", "Tesla", "Model X", 4, 2019, 250,
                150, 20000, 4, "150000V"));

        // when
        cartDAOImpl.addProductToCart("Model X");
        Map<String, Vehicle> result = cartDAOImpl.getCart().getCart();

        // then
        Assert.assertEquals(new HashMap<String, Vehicle>() {{
            put("Model X", new ElectroCar("Electro Car", "USA", "Tesla",
                    "Model X", 4, 2019, 250, 150, 20000,
                    4, "150000V"));
        }}, result);
    }

    @Test
    public void shouldRemoveAllElementsFromCartWhenCallsMethodClearCart() {
        //given
        when(productDAOImpl.getProductByName(anyString())).thenReturn(new ElectroCar("Electro Car",
                "USA", "Tesla", "Model X", 4, 2019, 250,
                150, 20000, 4, "150000V"));

        //when
        cartDAOImpl.addProductToCart("Model X");
        cartDAOImpl.clearCart();

        //then
        Assert.assertEquals(new HashMap<String, Vehicle>(), cartDAOImpl.getCart().getCart());
    }

}
