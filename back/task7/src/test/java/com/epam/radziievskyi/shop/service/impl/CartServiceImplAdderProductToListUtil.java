package com.epam.radziievskyi.shop.service.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.shop.dao.impl.CartDAOImpl;
import com.epam.radziievskyi.shop.entity.CartEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CartServiceImplAdderProductToListUtil{

    @Mock
    CartDAOImpl cartDAO;
    @InjectMocks
    CartServiceImpl cartServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cartServiceImpl = new CartServiceImpl(cartDAO);
    }

    @Test
    void shouldReturnElementsFromCartWhenCallsMethodGetProductFromCart() {
        cartServiceImpl.getProductFromCart();
        verify(cartDAO, times(1)).getProductFromCart();
    }

    @Test
    void shouldAddChosenElementByProductListWhenCallsMethodAddProduct() {
        //given
        Vehicle tesla = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V");

        //when
        given(cartServiceImpl.getCart()).willReturn(new CartEntity(new HashMap<>()));
        cartServiceImpl.addProduct("Model X");
        when(cartServiceImpl.getCart()).thenReturn(new CartEntity(new HashMap<>()) {{
            getCart().put("Model X", tesla);
        }});

        //then
        Assertions.assertEquals(1, cartServiceImpl.getCart().getCart().size());
    }

    @Test
    void shouldRemoveChosenElementFromCartWhenCallsMethodRemoveProductFromCart() {
        //given
        String productName = "Model X";
        Vehicle tesla = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V");
        CartEntity cart = new CartEntity(new HashMap<>());

        //when
        cart.getCart().put(productName, tesla);
        when(cartServiceImpl.getCart()).thenReturn(cart);
        cartServiceImpl.removeProductFromCart(productName);
        given(cartServiceImpl.getCart()).willReturn(new CartEntity(new HashMap<>()));

        //then
        Assertions.assertEquals(new HashMap<>(), cartServiceImpl.getCart().getCart());
    }

    @Test
    void shouldDeleteAllElementsFromCartWhenCallsMethodClearCart() {
        //given
        String productName = "Model X";
        Vehicle tesla = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000, 4,
                "150000V");
        CartEntity cart = new CartEntity(new HashMap<>());

        //when
        cart.getCart().put(productName, tesla);
        when(cartServiceImpl.getCart()).thenReturn(cart);
        cartServiceImpl.clearCart();
        given(cartServiceImpl.getCart()).willReturn(new CartEntity(new HashMap<>()));

        //then
        Assertions.assertEquals(new HashMap<>(), cartServiceImpl.getCart().getCart());
    }

    @Test
    void shouldreturnCartWhenCallsMethodGetCart() {
        //given
        String productName = "Model X";

        Vehicle tesla = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V");
        CartEntity cart = new CartEntity(new HashMap<>());

        //when
        cart.getCart().put(productName, tesla);
        when(cartServiceImpl.getCart()).thenReturn(cart);

        //then
        Assertions.assertEquals(cart, cartServiceImpl.getCart());
    }

}