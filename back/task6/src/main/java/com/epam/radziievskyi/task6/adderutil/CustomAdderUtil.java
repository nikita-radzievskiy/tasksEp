package com.epam.radziievskyi.task6.adderutil;

import com.epam.radziievskyi.entity.BenzoCar;
import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.SeaVehicle;
import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.container.ProductContainer;
import com.epam.radziievskyi.task6.strategy.impl.CustomStrategyImpl;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class CustomAdderUtil {

    private static final Logger LOGGER = Logger.getLogger(CustomStrategyImpl.class);

    private final ProductContainer productContainer = new ProductContainer();

    public void addProduct() {
        LOGGER.debug("Method addProduct() in class CustomStrategyImpl was called");
        System.out.println("----------------------------------------------------");
        System.out.println("Choose: 1 - Land vehicle, 2 - Sea vehicle");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("----------------------------------------------------");
                System.out.println("Choose: 1 - Benzo car, 2 - Electro car");
                int choice1 = scanner.nextInt();
                switch (choice1) {
                    case 1:
                        addBenzoCar(scanner);
                        break;
                    case 2:
                        addElectroCar(scanner);
                        break;
                    default:
                        wrongMessage();
                        break;
                }
                break;
            case 2:
                addSeaVehicle(scanner);
                break;
            default:
                wrongMessage();
                break;
        }
    }

    private void wrongMessage() {
        System.out.println("----------------------------------------------------");
        System.out.println("Wrong choice");
        LOGGER.debug("Wrong choice");
    }

    private void addSeaVehicle(Scanner scanner) {
        LOGGER.debug("User choose Sea vehicle");
        System.out.println("----------------------------------------------------");
        System.out.print("Enter Sea vehicle name of Product: ");
        String nameOfProductSea = scanner.next();
        System.out.print("Enter Sea vehicle country: ");
        String countrySea = scanner.next();
        System.out.print("Enter Sea vehicle brand: ");
        String brandSea = scanner.next();
        System.out.print("Enter Sea vehicle model: ");
        String modelSea = scanner.next();
        System.out.print("Enter Sea vehicle passengers: ");
        int passengersSea = Integer.parseInt(scanner.next());
        System.out.print("Enter Sea vehicle year: ");
        int yearSea = Integer.parseInt(scanner.next());
        System.out.print("Enter Sea vehicle max speed: ");
        int maxSpeedSea = Integer.parseInt(scanner.next());
        System.out.print("Enter Sea vehicle horse power: ");
        int horsePowerSea = Integer.parseInt(scanner.next());
        System.out.print("Enter Sea vehicle price: ");
        double priceSea = Double.parseDouble(scanner.next());
        System.out.print("Enter Sea vehicle material: ");
        String material = scanner.next();

        productContainer.addProduct(new SeaVehicle
                (nameOfProductSea, countrySea, brandSea, modelSea, passengersSea, yearSea, maxSpeedSea, horsePowerSea, priceSea, material));
        LOGGER.debug("Sea vehicle was added to container");
    }

    private void addElectroCar(Scanner scanner) {
        LOGGER.debug("User choose Electro car");
        System.out.println("----------------------------------------------------");
        System.out.print("Enter Electro car's name of Product: ");
        String nameOfProductEl = scanner.next();
        System.out.print("Enter Electro car's country: ");
        String countryEl = scanner.next();
        System.out.print("Enter Electro car's brand: ");
        String brandEl = scanner.next();
        System.out.print("Enter Electro car's model: ");
        String modelEl = scanner.next();
        System.out.print("Enter Electro car's passengers: ");
        int passengersEl = Integer.parseInt(scanner.next());
        System.out.print("Enter Electro car's year: ");
        int yearEl = Integer.parseInt(scanner.next());
        System.out.print("Enter Electro car's max speed: ");
        int maxSpeedEl = Integer.parseInt(scanner.next());
        System.out.print("Enter Electro car's horse power: ");
        int horsePowerEl = Integer.parseInt(scanner.next());
        System.out.print("Enter Electro car's price: ");
        double priceEl = Double.parseDouble(scanner.next());
        System.out.print("Enter Electro car's wheels: ");
        int wheelsEl = Integer.parseInt(scanner.next());
        System.out.print("Enter Electro car's battery capacity: ");
        String batteryCapacityEl = scanner.next();

        productContainer.addProduct(new ElectroCar
                (nameOfProductEl, countryEl, brandEl, modelEl, passengersEl, yearEl, maxSpeedEl, horsePowerEl, priceEl, wheelsEl, batteryCapacityEl));
        LOGGER.debug("Electro car was added to container");
    }

    private void addBenzoCar(Scanner scanner) {
        LOGGER.debug("User choose Benzo car");
        System.out.println("----------------------------------------------------");
        System.out.print("Enter Benzo car's name of Product: ");
        String nameOfProduct = scanner.next();
        System.out.print("Enter Benzo car's country: ");
        String country = scanner.next();
        System.out.print("Enter Benzo car's brand: ");
        String brand = scanner.next();
        System.out.print("Enter Benzo car's model: ");
        String model = scanner.next();
        System.out.print("Enter Benzo car's passengers: ");
        int passengers = Integer.parseInt(scanner.next());
        System.out.print("Enter Benzo car's year: ");
        int year = Integer.parseInt(scanner.next());
        System.out.print("Enter Benzo car's max speed: ");
        int maxSpeed = Integer.parseInt(scanner.next());
        System.out.print("Enter Benzo car's horse power: ");
        int horsePower = Integer.parseInt(scanner.next());
        System.out.print("Enter Benzo car's price: ");
        double price = Double.parseDouble(scanner.next());
        System.out.print("Enter Benzo car's wheels: ");
        int wheels = Integer.parseInt(scanner.next());
        System.out.print("Enter Benzo car's battery capacity: ");
        String fuelCapacity = scanner.next();

        productContainer.addProduct(new BenzoCar
                (nameOfProduct, country, brand, model, passengers, year, maxSpeed, horsePower, price, wheels, fuelCapacity));
        LOGGER.debug("Benzo car was added to container");
    }

    public List<Vehicle> getAllVehicles() {
        return productContainer.getAllProducts();
    }

}
