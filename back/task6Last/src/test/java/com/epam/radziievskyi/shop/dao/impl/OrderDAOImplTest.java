package com.epam.radziievskyi.shop.dao.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.shop.entity.CartEntity;
import com.epam.radziievskyi.shop.utils.DateUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;

class OrderDAOImplTest {
    @InjectMocks
    OrderDAOImpl orderDAOImpl;


    Date date = new Date();
    @Spy
    Map<Date, CartEntity> order = new HashMap<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        orderDAOImpl = new OrderDAOImpl(order);
    }

    @Test
    void shouldRemoveChosenElementFromOrderWhenCallsMethodRemoveProductFromOrder() {
        //given
        CartEntity cart = new CartEntity(new HashMap<>());
        cart.getCart().put("Model X", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V"));
        order.put(date, cart);
        orderDAOImpl.addProductToOrder(date, cart);

        //when
        orderDAOImpl.removeProductFromOrder(date, cart);

        //then
        Assertions.assertEquals(0, orderDAOImpl.getOrder().size());
    }

    @Test
    void shouldReturnAllListWithProductsFromOrderWhenCallsMethodGetAllOrder() {
        //given
        CartEntity cart = new CartEntity(new HashMap<>());
        cart.getCart().put("Model X", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V"));

        // when
        orderDAOImpl.addProductToOrder(date, cart);
        Map<Date, CartEntity> result = orderDAOImpl.getOrder();

        // then
        assertEquals(new HashMap<Date, CartEntity>() {
            {
                put(date, cart);
            }
        }, result);
    }

    @Test
    void shouldAddElementToOrderWhenCallsMethodAddToOrder() {
        //given
        CartEntity cart = new CartEntity(new HashMap<>());
        cart.getCart().put("Model X", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V"));
        order.put(date, cart);

        //when
        orderDAOImpl.addProductToOrder(date, cart);

        //then
        Assert.assertEquals(1, orderDAOImpl.getOrder().size());
    }

    @Test
    void shouldReturnPriceOfOrderWhenCallsMethodGetTotalPrice() {
        //given
        CartEntity cart = new CartEntity(new HashMap<>());
        cart.getCart().put("Model X", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V"));
        order.put(date, cart);

        //when
        orderDAOImpl.addProductToOrder(date, cart);

        //then
        assertEquals(20000, orderDAOImpl.getTotalPrice());
    }

    @Test
    void shouldReturnChosenElementsWhenCallsMethodFindByDate() {
        //given
        Date startDate = new Date();
        Date endDate = new Date();
        OrderDAOImpl mock = Mockito.mock(OrderDAOImpl.class);
        Vehicle car = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V");
        Vehicle car2 = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model Y", 4, 2019, 250, 150, 20000,
                4, "150000V");
        CartEntity cart = new CartEntity(new HashMap<>());
        cart.getCart().put("Model X", car);
        cart.getCart().put("Model Y", car2);
        order.put(startDate, cart);
        order.put(endDate, cart);

        //when
        orderDAOImpl.addProductToOrder(startDate, cart);
        orderDAOImpl.addProductToOrder(endDate, cart);

        //then
        doThrow(new IllegalArgumentException()).when(mock).findBetweenDates(startDate, endDate);
    }

    @Test
    void shouldRemoveAllElementsFromOrderWhenCallsMethodCleanOrder() {
        //given
        CartEntity cart = new CartEntity(new HashMap<>());
        cart.getCart().put("Model X", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V"));
        order.put(date, cart);

        //when
        orderDAOImpl.addProductToOrder(date, cart);
        orderDAOImpl.removeProductFromOrder(date, cart);

        //then
        Assertions.assertEquals(0, orderDAOImpl.getOrder().size());
    }

    @Test
    void shouldReturnBooleanWhenCallsMethodOrderIsEmpty() {
        //given
        CartEntity cart = new CartEntity(new HashMap<>());
        cart.getCart().put("Model X", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V"));
        order.put(date, cart);

        //when
        orderDAOImpl.addProductToOrder(date, cart);
        orderDAOImpl.removeProductFromOrder(date, cart);

        //then
        assertTrue(orderDAOImpl.orderIsEmpty());
    }

    @Test
    void shouldReturnChosenElementsFromOrderWhenCallsMethodGetLastElement() {
        OrderDAOImpl mock = Mockito.mock(OrderDAOImpl.class);
        //given
        int element = 1;
        CartEntity cart = new CartEntity(new HashMap<>());
        cart.getCart().put("Model X", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V"));
        order.put(date, cart);

        //when
        orderDAOImpl.addProductToOrder(date, cart);

        //then
        doThrow(new IllegalArgumentException()).when(mock).getLastElements(element);
    }

    @Test
    void shouldReturnNearestAndUpcomingOrdersWhenCallsMethodFindNearestAndUpcomingOrder() {
        //given
        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();
        Date date4 = new Date();
        OrderDAOImpl mock = Mockito.mock(OrderDAOImpl.class);
        Vehicle car = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V");
        Vehicle car2 = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model Y", 4, 2019, 250, 150, 20000,
                4, "150000V");
        Vehicle car3 = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V");
        Vehicle car4 = new ElectroCar("Electro Car", "USA", "Tesla",
                "Model Y", 4, 2019, 250, 150, 20000,
                4, "150000V");

        CartEntity cart = new CartEntity(new HashMap<>());
        cart.getCart().put("Model X", car);
        cart.getCart().put("Model Y", car2);
        cart.getCart().put("Model Z", car3);
        cart.getCart().put("Model A", car4);

        //when
        order.put(date1, cart);
        order.put(date2, cart);
        order.put(date3, cart);
        order.put(date4, cart);

        //then
        doThrow(new IllegalArgumentException()).when(mock).findNearestAndUpcomingOrder(date1);
    }

}