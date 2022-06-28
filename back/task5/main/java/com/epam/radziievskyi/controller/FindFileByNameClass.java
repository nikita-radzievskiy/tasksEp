package com.epam.radziievskyi.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFileByNameClass {
    private static String path = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();
        try {
            List<String> files = findFiles(Paths.get(path), fileName);
            if (files.isEmpty()) {
                System.out.println("Files not found");
            } else {
                files.forEach(x -> System.out.println(x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> findFiles(Path path, String nameOfFile) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IOException("Path is not a directory");
        }
        Stream<Path> stream = Files.find(path, Integer.MAX_VALUE, (path1, attr) -> attr.isRegularFile());
        return stream.map(x -> x.toString()).filter(x -> x.contains(nameOfFile)).collect(Collectors.toList());
    }


}



