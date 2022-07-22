package com.epam.radziievskyi.filereader.readlinebyline.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ReaderForTxtUtil implements Iterable<String> {

    private final static Logger LOGGER = Logger.getLogger(ReaderForTxtUtil.class);

    private final String DIRECTORY = "/Users/pro/Desktop/pre_prod_java_winter_2022/";

    private String filePath;
    private String fileName;


    public ReaderForTxtUtil(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public ReaderForTxtUtil() {
    }

    @Override
    public Iterator<String> iterator() {
        return new ReaderForTxtIterator();
    }

    public void run() {
        System.out.println("Enter file path in format: src/main/resources/filesTask5/txt/");
        Scanner pathScanner = new Scanner(System.in);
        String filePath = pathScanner.nextLine();
        System.out.println("Enter file name in format: text");
        Scanner nameScanner = new Scanner(System.in);
        String fileName = nameScanner.nextLine();

        LOGGER.info("Reading file " + fileName + " from " + filePath);
        ReaderForTxtUtil readerForTxtUtil = new ReaderForTxtUtil(filePath, fileName);
        for (String line : readerForTxtUtil) {
            System.out.println(line);
        }
        LOGGER.info("File read");
    }

    private class ReaderForTxtIterator implements Iterator<String> {

        private BufferedReader bufferedReader;

        public ReaderForTxtIterator() {
            try {
                bufferedReader = new BufferedReader(new FileReader(DIRECTORY + filePath + fileName));
            } catch (FileNotFoundException fileNotFoundException) {
                LOGGER.error("File not found", fileNotFoundException);
                System.out.println("File not found");
            }
        }

        @Override
        public boolean hasNext() {
            try {
                return bufferedReader.ready();
            } catch (IOException | NullPointerException exception) {
                LOGGER.error("Error while reading file", exception);
                System.out.println("Error while reading file");
            }
            return false;
        }

        @Override
        public String next() {
            try {
                return bufferedReader.readLine();
            } catch (IOException ioException) {
                LOGGER.error("Error while reading file", ioException);
                System.out.println("Error while reading file");
            }
            return StringUtils.EMPTY;
        }
    }

}


