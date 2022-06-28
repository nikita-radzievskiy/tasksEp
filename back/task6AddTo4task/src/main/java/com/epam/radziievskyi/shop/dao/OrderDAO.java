package com.epam.radziievskyi.shop.dao;

import com.epam.radziievskyi.shop.entity.CartEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public interface OrderDAO {

    void removeProductFromOrder(Date time, CartEntity cart);

    Map<Date, CartEntity> getAllOrder();

    void addProductToOrder(Date time, CartEntity cart) throws ParseException;

    double getTotalPrice();

    void findBetweenDates(Date startDate, Date endDate);

    void findNearestAndUpcomingOrder(Date date);

    void clearOrder();

    boolean orderIsEmpty();

    void getLastElements(int elements);

    Map<Date, CartEntity> getOrder();

}