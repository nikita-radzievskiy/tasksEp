package com.epam.radziievskyi.task7_1.reflection;

import com.epam.radziievskyi.shop.controller.product.AddProductReflectionCommandImpl;
import com.epam.radziievskyi.shop.service.ProductService;
import com.epam.radziievskyi.task6.strategy.inputstrategy.InputStrategy;
import com.epam.radziievskyi.task6.template.AbstractMethodTemplate;
import com.epam.radziievskyi.task6.template.impl.BenzoCarTemplate;
import com.epam.radziievskyi.task6.template.impl.ElectroCarTemplate;
import com.epam.radziievskyi.task6.template.impl.SeaVehicleTemplate;
import com.epam.radziievskyi.task7_1.annotation.ProductSetter;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ProductCreatorReflection {

    private final static Logger LOGGER = Logger.getLogger(ProductCreatorReflection.class);
    private static final String HEADER_FOR_MENU = "enter.type.of.the.product";
    private static final String ELECTRO_CAR = "ElectroCar";
    private static final String BENZO_CAR = "BenzoCar";
    private static final String SEA_VEHICLE = "SeaVehicle";
    private final Map<String, AbstractMethodTemplate> vehicles;
    private final InputStrategy inputStrategy;
    private final ResourceBundle resourceBundle;

    public ProductCreatorReflection(InputStrategy inputStrategy, ResourceBundle resourceBundle) {
        this.inputStrategy = inputStrategy;
        this.resourceBundle = resourceBundle;
        this.vehicles = fillMap();
    }

    /**
     * Method creates product by using reflection and will check if product is created successfully.
     * And check if user input is correct.
     *
     * @return product
     */
    public AbstractMethodTemplate createProduct() {
        Scanner scanner = new Scanner(System.in);
        String chooseTypeOfVehicle = scanner.next();
        while (true) {
            choose(chooseTypeOfVehicle);
            if (vehicles.containsKey(chooseTypeOfVehicle)) {
                AbstractMethodTemplate product = vehicles.get(chooseTypeOfVehicle);
                fill(product);
                LOGGER.info("Product created");
                return product;
            } else {
                LOGGER.debug("Method createProduct() was called with wrong chooseTypeOfVehicle");
                System.out.println("Wrong chooseTypeOfVehicle");
                return createProduct();
            }
        }
    }

    /**
     * Method fills product with user input
     *
     * @param method  with {@link ProductSetter} annotation
     *                and with the same return type as method parameter
     *                and with the same name as method parameter
     *                and with the same type as method parameter
     * @param vehicle with user input or generated random value
     *                and will be added to the product
     *                and will be added to the list
     *                and will be returned
     * @return vehicle with user input or generated random value
     */
    private void invokeIfAnnotationPresent(Method method, AbstractMethodTemplate vehicle) {
        if (method.isAnnotationPresent(ProductSetter.class)) {
            Method[] methods = inputStrategy.getClass().getDeclaredMethods();
            LOGGER.info("Enter " + method.getName() + ":");
            fillAllProductOptions(method, vehicle, methods);
        }
    }

    /**
     * Method fills product with user input
     *
     * @param method      with {@link ProductSetter} annotation
     *                    and with the same return type as method parameter
     *                    and with the same name as method parameter
     *                    and with the same type as method parameter
     * @param vehicle     with user input or generated random value
     *                    and will be added to the product
     *                    and will be added to the list
     *                    and will be returned
     * @param inputMethod with user input or generated random value
     *                    and will be added to the product
     *                    and will be added to the list
     *                    and will be returned
     * @return vehicle with user input or generated random value
     */
    private void fillAllProductOptions(Method method, AbstractMethodTemplate vehicle, Method[] inputMethod) {
        for (Method allMethods : inputMethod) {
            if ((method.getParameterTypes()[0]).equals(allMethods.getReturnType())) {
                try {
                    method.invoke(vehicle, allMethods.invoke(inputStrategy, resourceBundle
                            .getString(method.getAnnotation(ProductSetter.class).name())));
                    LOGGER.info("Product created" + method.getAnnotation(ProductSetter.class).name());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method fills product with user input
     *
     * @param vehicle with user input or generated random value
     *                and will be added to the product
     *                and will be added to the list
     *                and will be returned
     * @return product with user input or generated random value
     */

    private void fill(AbstractMethodTemplate vehicle) {
        Class createdProduct = vehicle.getClass();
        Method[] methods = createdProduct.getMethods();
        for (Method method : methods) {
            invokeIfAnnotationPresent(method, vehicle);
        }
    }

    /**
     * Method fills map with products
     *
     * @return map with products
     */
    private Map<String, AbstractMethodTemplate> fillMap() {
        Map<String, AbstractMethodTemplate> vehicles = new HashMap<>();
        vehicles.put("1", new ElectroCarTemplate(inputStrategy, resourceBundle));
        vehicles.put("2", new BenzoCarTemplate(inputStrategy, resourceBundle));
        vehicles.put("3", new SeaVehicleTemplate(inputStrategy, resourceBundle));
        return vehicles;
    }

    /**
     * Method chooses product by user input and this method should
     * to check if user input is correct
     *
     * @param input with user input in {@link AddProductReflectionCommandImpl}
     * @return product which was created and will be added to the list
     */
    public String choose(String input) {
        while (true) {
            try {
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Enter only numbers");
                LOGGER.info("Invalid input by letters");
                return input;
            }

        }
    }
    public void printMenu() {
        System.out.println("-----------------------------------------------------");
        System.out.println(resourceBundle.getString(HEADER_FOR_MENU));
        System.out.println("1. " + resourceBundle.getString(ELECTRO_CAR));
        System.out.println("2. " + resourceBundle.getString(BENZO_CAR));
        System.out.println("3. " + resourceBundle.getString(SEA_VEHICLE));
        System.out.println("-----------------------------------------------------");
    }

}
