package com.epam.radziievskyi.task6.serializer.impl;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;

class SerializerImplAdderProductToListUtil{

    private final String FILE_PATH = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/serialization/serialized.GZip";

    @InjectMocks
    SerializerImpl serializerImpl;


    private final SerializerImpl serializerImplMock = mock(SerializerImpl.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        serializerImpl = new SerializerImpl();
    }

    @Test
    void shouldSerializeFileWhenCallsMethodSerialize() {
        //given
        List<Vehicle> vehicles = Arrays.asList(
                new ElectroCar("Electro Car", "USA", "Tesla",
                        "Model X", 4, 2019, 250, 150, 20000,
                        4, "150000V"));

        //when
        serializerImplMock.serialize(vehicles);

        //then
        Assertions.assertDoesNotThrow(() -> serializerImplMock.serialize(vehicles));

    }

    @Test
    void shouldDeserializeFileWhenCallsMethodDeserialize() {
        //given
        List<Vehicle> vehicles = Arrays.asList(
                new ElectroCar("Electro Car", "USA", "Tesla",
                        "Model X", 4, 2019, 250, 150, 20000,
                        4, "150000V"));

        //when
        serializerImplMock.deserialize();

        //then
        Assertions.assertDoesNotThrow(() -> serializerImplMock.deserialize());
    }

    @Test
    void shouldReturnBooleanAndCheckFileToDeserializeWhenCallsMethodCheckDeserialize() {
        //given
        List<Vehicle> vehicles = Arrays.asList(
                new ElectroCar("Electro Car", "USA", "Tesla",
                        "Model X", 4, 2019, 250, 150, 20000,
                        4, "150000V"));

        //when
        serializerImplMock.checkDeserialize();

        //then
        Assertions.assertDoesNotThrow(() -> serializerImplMock.checkDeserialize());
    }

    @Test
    void shouldAddEmptySpaceAndClearFileWhenCallsMethodClearFile() {
        //given
        List<Vehicle> vehicles = Arrays.asList(
                new ElectroCar("Electro Car", "USA", "Tesla",
                        "Model X", 4, 2019, 250, 150, 20000,
                        4, "150000V"));

        //when
        serializerImplMock.clearFile(FILE_PATH);

        //then
        Assertions.assertDoesNotThrow(() -> serializerImplMock.clearFile(FILE_PATH));
    }

}
