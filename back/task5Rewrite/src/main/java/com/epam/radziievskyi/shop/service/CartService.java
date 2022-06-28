package com.epam.radziievskyi.shop.service;

import com.epam.radziievskyi.shop.entity.CartEntity;

public interface CartService {

    void addProduct(String productId);

    void removeProductFromCart(String productName);

    void clearCart();

    CartEntity getCart();

    void getProductFromCart();

}
