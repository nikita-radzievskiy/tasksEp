package com.epam.radziievskyi.task6.serializer;

import com.epam.radziievskyi.entity.Vehicle;

import java.util.List;

public interface Serializer {

    boolean serialize(List<Object> allProducts);

    List<Vehicle> deserialize();

    boolean checkDeserialize();

    void clearFile(String filePath);

}
