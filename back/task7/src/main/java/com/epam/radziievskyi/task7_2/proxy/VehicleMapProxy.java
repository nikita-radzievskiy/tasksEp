package com.epam.radziievskyi.task7_2.proxy;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class VehicleMapProxy implements InvocationHandler {

    private final static Logger LOGGER = Logger.getLogger(VehicleMapProxy.class);
    private final Map<String, Object> map;

    private final Map<Class, Object> defaultValues = new HashMap<>();

    public VehicleMapProxy() {
        initDefaultValues();
        map = new HashMap<>();
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
            LOGGER.debug("Called setter " + method.getName());
            return map.put(method.getName().substring(3).toLowerCase(), args[0]);
        } else if (method.getName().startsWith("get")) {
            if (map.get(method.getName().substring(3).toLowerCase()) == null) {
                LOGGER.debug("Called getter " + method.getName());
                return defaultValues.get(method.getReturnType());
            }
            LOGGER.debug("Called getter " + method.getName());
            return map.get(method.getName().substring(3).toLowerCase());
        }
        LOGGER.debug("Called method " + method.getName());
        throw new NoSuchMethodException();
    }

    /**
     * Initializes default values for the map
     * (0 for int, null for other types)
     */
    private void initDefaultValues() {
        defaultValues.put(int.class, 0);
        LOGGER.debug("Initialized default values " + defaultValues);
    }

}
