package com.epam.radziievskyi.shop.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateUtil {

    public DateUtil () {
    }

    public Date formatDate () throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date and time in format dd.MM.yyyy HH:mm");
        String input = scanner.nextLine();
        return new Date(dateFormat.parse(input).getTime());
    }

}
