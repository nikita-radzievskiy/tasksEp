package com.epam.radziievskyi.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindBySizeClass {
    private static String path = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources";


    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter size of file on bytes");

            double size = scanner.nextDouble();
            List<String> files = findFiles(new File(path).toPath(), size);
            files.forEach(System.out::println);
            if (files.isEmpty()) {
                System.out.println("No files with size more than " + size + " bytes");
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Incorrect input and use only numbers");
        }

    }

    public static List<String> findFiles(Path path, double size) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IOException("Path is not a directory");
        }
        List<String> files = Files.walk(path).filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList());
        return files.stream().filter(file -> {
            try {
                return Files.size(new File(file).toPath()) > size;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());
    }

}