package com.epam.radziievskyi.task6.strategy;

import java.io.IOException;
import java.util.Scanner;

public interface InputStrategy {

    String getString (String message, Scanner scanner);

    int getInteger (String message, Scanner scanner) throws IOException;

}