package com.epam.radziievskyi.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFileByFormatClass {

    private static String path = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file extension: ");
        String fileExtension = scanner.nextLine();
        try {
            List<String> files = findFiles(Paths.get(path), fileExtension);
            if (files.isEmpty()) {
                System.out.println("Files not found");
            } else {
                files.forEach(x -> System.out.println(x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> findFiles(Path path, String fileExtension) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }
        List<String> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(fileExtension))
                    .collect(Collectors.toList());
        }
        return result;
    }
}