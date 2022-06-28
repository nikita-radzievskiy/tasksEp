package com.epam.radziievskyi.task6.strategy.impl;

import com.epam.radziievskyi.task6.adderutil.RandomAdderUtil;
import com.epam.radziievskyi.task6.serializer.impl.SerializerImpl;
import com.epam.radziievskyi.task6.strategy.Strategy;
import org.apache.log4j.Logger;

import java.util.Collections;

public class RandomStrategyImpl implements Strategy {

    private static final Logger LOGGER = Logger.getLogger(RandomStrategyImpl.class);

    private final RandomAdderUtil randomAdder = new RandomAdderUtil();

    private final SerializerImpl serializerImpl = new SerializerImpl();

    @Override
    public void addProduct () {
        System.out.println("Desialization: \n");
        if (serializerImpl.deserialize() != null) {
            LOGGER.debug("File was deserialized");
            System.out.println(serializerImpl.deserialize());
        } else {
            LOGGER.debug("File was not deserialized");
        }
        System.out.println("----------------------------------------------------\n");
        serializerImpl.serialize(Collections.singletonList(randomAdder.converterToList()));
    }

}
