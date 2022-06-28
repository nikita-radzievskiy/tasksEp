package com.epam.radziievskyi.task6.writetofilentimes;

import com.epam.radziievskyi.entity.SeaVehicle;
import com.epam.radziievskyi.task6.container.ProductContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.when;

class AdderNTimesToFileTest {

    private final String FILE_PATH_COMPRESS = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/serialization/compress.GZip";
    private final String FILE_PATH = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/serialization/serialized.GZip";

    @Mock
    ProductContainer productContainer;
    @InjectMocks
    AdderNTimesToFile adderNTimesToFile;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        adderNTimesToFile = new AdderNTimesToFile();
    }

    @Test
    void shouldSerializeToFileNTimesAndShowSizeOfFileWhenCallsMethodAddNTimesToFile() {
        String compress = "Compressed file ";
        String serialized = "Serialized file ";
        //given
        when(productContainer.listWitProducts()).thenReturn(Arrays.asList(
                new SeaVehicle("nameOfProduct", "manufacturerCountry",
                        "brand", "model", 0, 0, 0, 0, 0d,
                        null)));

        //then
        adderNTimesToFile.compressGzip();

        adderNTimesToFile.addNTimesToFile(5);
        System.out.println(compress + adderNTimesToFile.sizeOfFile(FILE_PATH_COMPRESS));
        System.out.println(serialized + adderNTimesToFile.sizeOfFile(FILE_PATH) + "\n");

        adderNTimesToFile.addNTimesToFile(10);
        System.out.println(compress + adderNTimesToFile.sizeOfFile(FILE_PATH_COMPRESS));
        System.out.println(serialized + adderNTimesToFile.sizeOfFile(FILE_PATH) + "\n");

        adderNTimesToFile.addNTimesToFile(40);
        System.out.println(compress + adderNTimesToFile.sizeOfFile(FILE_PATH_COMPRESS));
        System.out.println(serialized + adderNTimesToFile.sizeOfFile(FILE_PATH) + "\n");

        adderNTimesToFile.clearFile(FILE_PATH);
        adderNTimesToFile.clearFile(FILE_PATH_COMPRESS);
    }

}
