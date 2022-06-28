package com.epam.radziievskyi.shop.container;

import com.epam.radziievskyi.shop.ApplicationContext;
import com.epam.radziievskyi.shop.controller.Command;
import com.epam.radziievskyi.shop.controller.DefaultCommandImpl;
import com.epam.radziievskyi.shop.controller.ExitCommand;
import com.epam.radziievskyi.shop.controller.cart.AddToCartCommandImpl;
import com.epam.radziievskyi.shop.controller.cart.ClearCartCommandImpl;
import com.epam.radziievskyi.shop.controller.cart.RemoveFromCartCommandImpl;
import com.epam.radziievskyi.shop.controller.cart.ShowCartCommandImpl;
import com.epam.radziievskyi.shop.controller.order.AddProductsToOrderCommandImpl;
import com.epam.radziievskyi.shop.controller.order.ClearOrderCommandImpl;
import com.epam.radziievskyi.shop.controller.order.FindByDateCommandImpl;
import com.epam.radziievskyi.shop.controller.order.FindNearestAndUpcomingOrderCommandImpl;
import com.epam.radziievskyi.shop.controller.order.GetLastElementsFromOrderListImpl;
import com.epam.radziievskyi.shop.controller.order.RemoveFromOrderCommandImpl;
import com.epam.radziievskyi.shop.controller.order.ShowOrderCommandImpl;
import com.epam.radziievskyi.shop.controller.product.ShowAllProductsCommandImpl;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private Map<String, Command> commandContainer;

    private ApplicationContext applicationContext;

    public CommandContainer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        commandContainer = new HashMap<>();
        fillCommandsMap();
    }

    private void fillCommandsMap() {
        commandContainer.put("1", new ShowAllProductsCommandImpl(applicationContext.getProductService()));
        commandContainer.put("2", new ShowCartCommandImpl(applicationContext.getCartService(), applicationContext.getCartDao()));
        commandContainer.put("3", new AddToCartCommandImpl(applicationContext.getCartService(), applicationContext.getProductService()));
        commandContainer.put("4", new ClearCartCommandImpl(applicationContext.getCartService()));
        commandContainer.put("5", new RemoveFromCartCommandImpl(applicationContext.getCartService()));
        commandContainer.put("6", new ShowOrderCommandImpl(applicationContext.getOrderService()));
        commandContainer.put("7", new AddProductsToOrderCommandImpl(applicationContext.getOrderService(), applicationContext.getOrderDao(), applicationContext.getCartService(), applicationContext.getCartDao()));
        commandContainer.put("8", new ClearOrderCommandImpl(applicationContext.getOrderService()));
        commandContainer.put("9", new RemoveFromOrderCommandImpl(applicationContext.getOrderService(), applicationContext.getCartDao(), applicationContext.getOrderDao()));
        commandContainer.put("10", new FindByDateCommandImpl(applicationContext.getOrderService()));
        commandContainer.put("11", new FindNearestAndUpcomingOrderCommandImpl(applicationContext.getOrderService()));
        commandContainer.put("12", new GetLastElementsFromOrderListImpl(applicationContext.getOrderService()));
        commandContainer.put("0", new ExitCommand(applicationContext.getExitMarker()));
    }

    public Command getCommand(String commandName) {
        return commandContainer.getOrDefault(commandName, new DefaultCommandImpl());
    }

}
