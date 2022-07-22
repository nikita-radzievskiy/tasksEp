package com.epam.radziievskyi.shop.entity;

import com.epam.radziievskyi.entity.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class CartEntity {

    private final Map<String, Vehicle> cart;

    public CartEntity () {
        this.cart = new HashMap<>();
    }

    public CartEntity (Map<String, Vehicle> cart) {
        this.cart = cart;
    }

    public Map<String, Vehicle> getCart () {
        return cart;
    }

    public CartEntity copy () {
        Map<String, Vehicle> cartCopy = new HashMap<>(cart);
        return new CartEntity(cartCopy);
    }

    public boolean isEmpty () {
        return cart.isEmpty();
    }

    public int size () {
        return cart.size();
    }

}
