package com.epam.radziievskyi.shop.service.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.shop.dao.impl.OrderDAOImpl;
import com.epam.radziievskyi.shop.entity.CartEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OrderServiceImplAdderProductToListUtil{

    private final Date date = new Date();
    @Mock
    OrderDAOImpl orderDao;
    @InjectMocks
    OrderServiceImpl orderServiceImpl;

    Date time = date;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        orderServiceImpl = new OrderServiceImpl(orderDao);
    }

    @Test
    void shouldAddElementToOrderWhenCalledMethodAddProductToOrder() {
        //given
        CartEntity map = new CartEntity(new HashMap<>());

        //when
        when(orderDao.getOrder()).thenReturn(new HashMap<Date, CartEntity>() {{
            put(time, map);
        }});
        orderServiceImpl.addProductToOrder(time, map);

        //then
        Assertions.assertEquals(1, orderServiceImpl.getOrder().size());
    }

    @Test
    void shouldRemoveChosenElementWhenCallsMethodRemoveProductFromOrder() {
        //given
        CartEntity map = new CartEntity(new HashMap<>());

        //when
        when(orderDao.getOrder()).thenReturn(new HashMap<Date, CartEntity>() {{
            put(time, map);
        }});
        orderServiceImpl.removeProductFromOrder(time, map);
        given(orderDao.getOrder()).willReturn(new HashMap<>());

        //then
        Assertions.assertEquals(0, orderServiceImpl.getOrder().size());
    }


    @Test
    void shouldClearAllOrderListWhenCallsMethodClearOrder() {
        //given
        CartEntity map = new CartEntity(new HashMap<>());

        //when
        when(orderDao.getOrder()).thenReturn(new HashMap<Date, CartEntity>() {{
            put(time, map);
        }});
        orderServiceImpl.clearOrder();
        given(orderDao.getOrder()).willReturn(new HashMap<>());

        //then
        Assertions.assertEquals(0, orderServiceImpl.getOrder().size());
    }

    @Test
    void shouldReturnAllOrderListWhenCallsMethodGetAllOrder() {
        //given
        CartEntity likeCart = new CartEntity(new HashMap<>());
        Map<Date, CartEntity> likeOrder = new HashMap<>();

        //when
        when(orderDao.getOrder()).thenReturn(new HashMap<Date, CartEntity>() {{
            put(time, likeCart);
        }});
        likeOrder.put(time, likeCart);
        given(orderDao.getOrder()).willReturn(likeOrder);
        orderServiceImpl.getAllOrder();

        //then
        Assertions.assertEquals(likeOrder, orderServiceImpl.getOrder());
    }

    @Test
    void shouldReturnPriceOfAllElementsInOrderWhenCallsMethodGetTotalPrice() {
        //given
        CartEntity map = new CartEntity(new HashMap<>());
        map.getCart().put("time", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V"));

        //when
        when(orderDao.getOrder()).thenReturn(new HashMap<Date, CartEntity>() {{
            put(time, map);
        }});
        orderServiceImpl.getTotalPrice();
        when(orderDao.getTotalPrice()).thenReturn(20000.0);

        //then
        verify(orderDao, times(1)).getTotalPrice();

    }

    @Test
    void shouldReturnChosenByDateWhenCallsMethodFindByDate() {
        //given
        Date start = new Date();
        Date end = new Date();
        CartEntity map = new CartEntity(new HashMap<>());
        map.getCart().put("time", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000,
                4, "150000V"));

        //when
        when(orderDao.getOrder()).thenReturn(new HashMap<Date, CartEntity>() {{
            put(time, map);
        }});
        orderServiceImpl.findBetweenDates(start, end);

        //then
        verify(orderDao, times(1)).findBetweenDates(start, end);
    }

    @Test
    void shouldReturnChosenLastEElementInOrderWhenCallsMethodGetLastElements() {
        //given
        CartEntity map = new CartEntity(new HashMap<>());
        map.getCart().put("time", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000, 4,
                "150000V"));
        map.getCart().put("time1", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000, 4,
                "150000V"));

        //when
        when(orderDao.getOrder()).thenReturn(new HashMap<Date, CartEntity>() {{
            put(time, map);
        }});
        orderServiceImpl.getLastElements(1);

        //then
        verify(orderDao, times(1)).getLastElements(1);
    }

    @Test
    void shouldReturnNearestAndUpcomingOrdersWhenCallsMethodFindNearestAndUpcomingOrder(){
        //given
        Date date = new Date();
        CartEntity map = new CartEntity(new HashMap<>());
        map.getCart().put("time", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000, 4,
                "150000V"));
        map.getCart().put("time1", new ElectroCar("Electro Car", "USA", "Tesla",
                "Model X", 4, 2019, 250, 150, 20000, 4,
                "150000V"));

        //when
        when(orderDao.getOrder()).thenReturn(new HashMap<Date, CartEntity>() {{
            put(time, map);
        }});
        orderServiceImpl.findNearestAndUpcomingOrder(date);

        //then
        verify(orderDao, times(1)).findNearestAndUpcomingOrder(date);
    }

}
