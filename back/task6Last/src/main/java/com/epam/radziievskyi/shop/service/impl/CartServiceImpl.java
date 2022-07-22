package com.epam.radziievskyi.shop.service.impl;

import com.epam.radziievskyi.shop.dao.impl.CartDAOImpl;
import com.epam.radziievskyi.shop.entity.CartEntity;
import com.epam.radziievskyi.shop.service.CartService;
import org.apache.log4j.Logger;

public class CartServiceImpl implements CartService {

    private final static Logger LOGGER = Logger.getLogger(CartServiceImpl.class);

    private final CartDAOImpl cartDAO;

    public CartServiceImpl (CartDAOImpl cartDao) {
        this.cartDAO = cartDao;
    }

    @Override
    public void getProductFromCart () {
        cartDAO.getProductFromCart();
        LOGGER.debug("Cart was printed");
    }

    @Override
    public void addProduct (String productId) {
        cartDAO.addProductToCart(productId);
    }

    @Override
    public void removeProductFromCart (String productName) {
        cartDAO.removeProductFromCart(productName);
        LOGGER.debug("Product " + productName + " was removed from cart");
    }

    @Override
    public void clearCart () {
        cartDAO.clearCart();
        LOGGER.debug("Cart was cleaned");
    }

    @Override
    public CartEntity getCart () {
        LOGGER.debug("Cart was returned");
        return cartDAO.getCart();
    }

}
