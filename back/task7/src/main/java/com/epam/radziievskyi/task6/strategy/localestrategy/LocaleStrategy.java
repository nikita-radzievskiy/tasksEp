package com.epam.radziievskyi.task6.strategy.localestrategy;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public interface LocaleStrategy {

    Scanner scanner = new Scanner(System.in);
    Map<String, Locale> locales = new HashMap<>();
    Locale EN = Locale.ENGLISH;
    Locale RU = new Locale("ru");

    Locale getLocale();

}
