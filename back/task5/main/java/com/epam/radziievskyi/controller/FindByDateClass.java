package com.epam.radziievskyi.controller;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class FindByDateClass implements FilenameFilter {

    String dateStart;
    String dateEnd;
    SimpleDateFormat sdf;
    private static String path = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources";


    public FindByDateClass(String dateStart, String dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    }

    public FindByDateClass() {

    }

    public boolean accept(File dir, String name) {
        Date d = new Date(new File(dir, name).lastModified());
        String current = sdf.format(d);
        return ((dateStart.compareTo(current) < 0
                && (dateEnd.compareTo(current) >= 0)));
    }


    public void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start date in format dd.MM.yyyy");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date in format dd.MM.yyyy");
        String endDate = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            FindByDateClass filter = new FindByDateClass(startDate, endDate);
            File folder = new File(path);
            File files[] = folder.listFiles(filter);
            if (files.length == 0) {
                System.out.println("Files not found");
            } else {
                System.out.println("Found " + files.length + " files");
                for (File f : files) {
                    System.out.println(sdf.format(new Date(f.lastModified())) + " | " + f.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong date format");
        }

    }
}

