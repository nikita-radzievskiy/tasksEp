package com.epam.radziievskyi.shop;

import com.epam.radziievskyi.shop.dao.impl.CartDAOImpl;
import com.epam.radziievskyi.shop.dao.impl.OrderDAOImpl;
import com.epam.radziievskyi.shop.dao.impl.ProductDAOImpl;
import com.epam.radziievskyi.shop.entity.CartEntity;
import com.epam.radziievskyi.shop.entity.ExitMarker;
import com.epam.radziievskyi.shop.service.CartService;
import com.epam.radziievskyi.shop.service.OrderService;
import com.epam.radziievskyi.shop.service.ProductService;
import com.epam.radziievskyi.shop.service.impl.CartServiceImpl;
import com.epam.radziievskyi.shop.service.impl.OrderServiceImpl;
import com.epam.radziievskyi.shop.service.impl.ProductServiceImpl;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task6.strategy.localestrategy.impl.ChooserForLocaleStrategyImpl;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class ApplicationContext {

    private final static Logger LOGGER = Logger.getLogger(ApplicationContext.class);
    private final static String BUNDLE_NAME = "resource";
    private final CartService cartService;
    private final ProductService productService;
    private final OrderService orderService;
    private final ProductDAOImpl productDAO;
    private final CartDAOImpl cartDao;
    private final OrderDAOImpl orderDao;
    private final ExitMarker exitMarker;
    private final InputStrategy strategy;


    public ApplicationContext(InputStrategy inputStrategy) {
        this.strategy = inputStrategy;
        ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        CartEntity cartMap = new CartEntity(new LinkedHashMap<>());
        Map<Date, CartEntity> orderMap = new TreeMap<>();
        productDAO = new ProductDAOImpl(resourceBundle);
        cartDao = new CartDAOImpl(cartMap, productDAO);
        orderDao = new OrderDAOImpl(orderMap);
        productService = new ProductServiceImpl(productDAO);
        cartService = new CartServiceImpl(cartDao);
        orderService = new OrderServiceImpl(orderDao);
        exitMarker = new ExitMarker(true);

        LOGGER.info("ApplicationContext created");
    }

    public CartService getCartService() {
        return cartService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public ExitMarker getExitMarker() {
        return exitMarker;
    }

    public CartDAOImpl getCartDao() {
        return cartDao;
    }

    public OrderDAOImpl getOrderDao() {
        return orderDao;
    }

    public InputStrategy getStrategy() {
        return strategy;
    }

    public ProductDAOImpl getProductDAO() {
        return productDAO;
    }

    public ResourceBundle getResourceBundle() {
//        try {
            return ResourceBundle.getBundle(BUNDLE_NAME, new ChooserForLocaleStrategyImpl().getLocale());
//        } catch (IllegalArgumentException illegalArgumentException) {
//            System.out.println("You entered wrong number\n");
//        }
//        return getResourceBundle();
    }

}
