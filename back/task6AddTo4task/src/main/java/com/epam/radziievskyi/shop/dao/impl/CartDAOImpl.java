package com.epam.radziievskyi.shop.dao.impl;

import com.epam.radziievskyi.shop.dao.CartDAO;
import com.epam.radziievskyi.shop.entity.CartEntity;
import org.apache.log4j.Logger;


public class CartDAOImpl implements CartDAO {

    private final static Logger LOGGER = Logger.getLogger(CartDAOImpl.class);

    private CartEntity cart;

    public CartDAOImpl(CartEntity cart) {
        this.cart = cart;
    }

    @Override
    public void addProductToCart(String id) {
        if (cart.getCart().containsKey(id)) {
            System.out.println("Product " + id + " is already in cart");
            LOGGER.error("Product " + id + " is already in cart");
        } else {
            cart.getCart().put(id, new ProductDAOImpl().getProductByName(id));
            LOGGER.debug("Product " + id + " was added to cart");
        }
    }

    @Override
    public CartEntity getProductFromCart() {
        System.out.println("Products in cart: ");
        cart.getCart().forEach((k, v) -> System.out.println(k + " " + v));
        return cart;
    }

    @Override
    public void removeProductFromCart(String name) {
        if (cart.getCart().containsKey(name)) {
            System.out.println("Product " + name + " was removed from cart");
            cart.getCart().remove(name);
        } else {
            LOGGER.error("Product is not in cart");
            System.out.println("Product is not in cart");
        }
    }

    @Override
    public CartEntity getCart() {
        LOGGER.debug("Cart was returned");
        return cart;
    }

    @Override
    public void clearCart() {
        LOGGER.debug("Cart was cleared");
        cart.getCart().clear();
    }

}

