package com.epam.radziievskyi.task7_2.proxy;

import com.epam.radziievskyi.task7_2.entity.VehicleInterface;
import com.epam.radziievskyi.task6.exception.UnModException;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UnmodifableProxy implements InvocationHandler {

    private final static Logger LOGGER = Logger.getLogger(UnmodifableProxy.class);
    private final VehicleInterface vehicle;

    public UnmodifableProxy(VehicleInterface vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Invokes method of the object that will be proxied
     *
     * @param proxy  proxy object
     * @param method method that will be invoked
     * @param args   arguments of the method
     * @return result of the method
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            LOGGER.debug("Exception in UnmodifableProxy");
            throw new UnModException();
        }
        LOGGER.debug("invoke in UnmodifableProxy");
        return method.invoke(vehicle, args);
    }

}
