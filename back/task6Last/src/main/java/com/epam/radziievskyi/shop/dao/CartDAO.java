package com.epam.radziievskyi.shop.dao;

import com.epam.radziievskyi.shop.entity.CartEntity;

public interface CartDAO {

    void addProductToCart (String id);

    CartEntity getProductFromCart ();

    void removeProductFromCart (String name);

    CartEntity getCart ();

    void clearCart ();

}
