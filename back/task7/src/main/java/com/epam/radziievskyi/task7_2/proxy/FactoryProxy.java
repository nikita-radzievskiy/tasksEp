package com.epam.radziievskyi.task7_2.proxy;

import com.epam.radziievskyi.task7_2.entity.VehicleInterface;
import com.epam.radziievskyi.task6.exception.UnModException;
import org.apache.log4j.Logger;

import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public class FactoryProxy {

    private final static Logger LOGGER = Logger.getLogger(FactoryProxy.class);

    /**
     * Creates proxy object for class {@link VehicleInterface}
     *
     * @param vehicle interface of object that will be proxied
     * @return proxy object
     */

    public VehicleInterface createProxy(VehicleInterface vehicle) {
        try {
            LOGGER.debug("Proxy created");
            return (VehicleInterface) Proxy.newProxyInstance(
                    VehicleInterface.class.getClassLoader(),
                    new Class[]{VehicleInterface.class},
                    new UnmodifableProxy(vehicle));
        } catch (UndeclaredThrowableException e) {
            LOGGER.debug("Exception in FactoryProxy");
            throw new UnModException();
        }
    }

    /**
     * Creates proxy map with key - class of object that will be proxied and value - proxy object
     * <p>
     * Map-based implementation of the commodity interface {@link VehicleInterface}
     * Calls to get/set methods of the commodity interface turn into calls to get/put
     * map, where field name will act as a key.
     */
    public VehicleInterface createProxyMap() {
        return (VehicleInterface) Proxy.newProxyInstance(
                VehicleInterface.class.getClassLoader(),
                new Class[]{VehicleInterface.class},
                new VehicleMapProxy());
    }

}
