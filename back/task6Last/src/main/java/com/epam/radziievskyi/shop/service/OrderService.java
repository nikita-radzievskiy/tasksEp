package com.epam.radziievskyi.shop.service;

import com.epam.radziievskyi.shop.entity.CartEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public interface OrderService {

    void addProductToOrder (Date time, CartEntity cart) throws ParseException;

    void removeProductFromOrder (Date time, CartEntity cart);

    void clearOrder ();

    void getAllOrder ();

    void getTotalPrice ();

    void findBetweenDates (Date start, Date end);

    void findNearestAndUpcomingOrder (Date date);

    void getLastElements (int number);

    Map<Date, CartEntity> getOrder ();

}
