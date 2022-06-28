package com.epam.radziievskyi.task6.adderutil;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.container.ProductContainer;
import com.epam.radziievskyi.task6.strategy.impl.RandomStrategyImpl;
import com.epam.radziievskyi.task6.utils.GenerateRandomUtil;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RandomAdderUtil {

    private static final Logger LOGGER = Logger.getLogger(RandomStrategyImpl.class);

    private final ProductContainer productContainer = new ProductContainer();
    private final Map<String, List<Vehicle>> order = new HashMap<>();

    public void addProduct() {
        GenerateRandomUtil generateRandomUtil = new GenerateRandomUtil();
        String key = "Фирма " + generateRandomUtil.randomNumbers();
        order.put(key, productContainer.listWitProducts());
        LOGGER.debug("Method addProduct() in class RandomStrategyImpl was called");
    }

    public List<Object> converterToList() {
        addProduct();
        List<Object> list = order.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "-" + entry.getValue())
                .sorted()
                .collect(Collectors.toList());
        LOGGER.debug("Map was converted to list");
        return list;
    }

    public Map<String, List<Vehicle>> getMap() {
        return order;
    }

}
