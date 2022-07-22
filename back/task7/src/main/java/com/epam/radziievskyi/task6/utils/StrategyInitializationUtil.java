package com.epam.radziievskyi.task6.utils;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.exception.ApplicationException;
import com.epam.radziievskyi.task6.serializer.impl.SerializerImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class StrategyInitializationUtil {

    private final static Logger LOGGER = Logger.getLogger(StrategyInitializationUtil.class);

    private final SerializerImpl serializerImpl = new SerializerImpl();

    public StrategyInitializationUtil() {
    }

    public void headerWriter() {
        System.out.println("Choose strategy: " +
                "\n1. Custom strategy" +
                "\n2. Random strategy");
    }

    public void deserializeFile() {
        System.out.println("Deserialization: \n");
        if (serializerImpl.deserialize() != null) {
            LOGGER.debug("File was deserialized");
            System.out.println(serializerImpl.deserialize());
        } else {
            LOGGER.debug("File was not deserialized");
            throw new ApplicationException();
        }
        System.out.println("----------------------------------------------------\n");
    }

    public void serializeFile(List<Vehicle> list) {
        serializerImpl.serialize(list);
        LOGGER.debug("File was serialized");
    }

}
