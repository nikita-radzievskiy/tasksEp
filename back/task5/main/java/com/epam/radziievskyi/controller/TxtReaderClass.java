package com.epam.radziievskyi.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TxtReaderClass {
    private static String path = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/";

    private String fileName;

    public TxtReaderClass(String fileName) {
        this.fileName = fileName;
    }

    public TxtReaderClass() {

    }

    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter file name");
            String fileName = scanner.nextLine();
            TxtReaderClass txtReaderClass = new TxtReaderClass(fileName);
            txtReaderClass.read();
            System.out.println("Do you want to continue? (y/n)");
            String answer = scanner.nextLine();
            if (answer.equals("n")) {
                break;
            } else if (answer.equals("y")) {
                continue;
            } else {
                System.out.println("Wrong answer");
            }
        }
    }

    public void read() {
        try {
            String filePath = path + fileName;
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < countLine(String.valueOf(file)); i++) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public long countLine(String fileName) {
        Path path = Paths.get(fileName);
        long lines = 0;
        try {
            lines = Files.lines(path).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        TxtReaderClass txtReaderClass = new TxtReaderClass();
        txtReaderClass.run();
    }
}
