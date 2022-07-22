package com.epam.radziievskyi.task6.serializer.impl;

import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.task6.exception.ApplicationException;
import com.epam.radziievskyi.task6.serializer.Serializer;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class SerializerImpl implements Serializer {

    private static final Logger LOGGER = Logger.getLogger(SerializerImpl.class);
    private static final File FILE_PATH = new File("src/main/resources/serialization/serialized.GZip");

    @Override
    public boolean serialize(List<Vehicle> allProducts) {

        boolean list = false;
        ObjectOutputStream objectOutputStream = null;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
            if (fileOutputStream != null) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(allProducts);
                list = true;
            }
        } catch (IOException fileNotFoundException) {
            System.out.println("File not found");
            LOGGER.error("File not found");
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException ioException) {
                System.out.println("Error while closing file");
                LOGGER.error("Error while closing file");
            }
        }
        LOGGER.debug(list + " was serialized");
        return list;
    }

    @Override
    public List<Vehicle> deserialize() {

        List<Vehicle> allProducts = null;
        ObjectInputStream ois = null;
        FileInputStream fis = null;

        try {
            if (FILE_PATH.exists()) {
                fis = new FileInputStream(FILE_PATH);
            }
            if (fis != null) {
                ois = new ObjectInputStream(fis);
                allProducts = (List<Vehicle>) ois.readObject();
                LOGGER.debug("Method deserialize() in class SerializerImpl was called");
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new ApplicationException();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException exception) {
                throw new ApplicationException();
            }
        }
        LOGGER.debug(allProducts + " was deserialized");
        return allProducts;
    }

    @Override
    public boolean checkDeserialize() {
        return FILE_PATH.exists();
    }

    @Override
    public Object deserializeVehicle() {
        Object object = null;
        ObjectInputStream ois = null;
        FileInputStream fis = null;

        try {
            if (FILE_PATH.exists()) {
                fis = new FileInputStream(FILE_PATH);
            }
            if (fis != null) {
                ois = new ObjectInputStream(fis);
                object = ois.readObject();
                LOGGER.debug("Method deserializeVehicle() in class SerializerImpl was called");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found");
            LOGGER.error("File not found");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException exception) {
                LOGGER.error("Error while closing file");
            }
        }
        LOGGER.debug(object + " was deserialized");
        return object;
    }

    @Override
    public void clearFile(String filePath) {
        try {
            PrintWriter printWriter = new PrintWriter(filePath);
            printWriter.print("");
            printWriter.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
            LOGGER.error("File not found" + ", can't clear file");
        }
    }

}


