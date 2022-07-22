package com.epam.radziievskyi.task6.writetofilentimes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class AdderNTimesToFileTest {

    private final String FILE_PATH_COMPRESS = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/serialization/compress.GZip";
    private final String FILE_PATH = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/serialization/serialized.GZip";

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

        //then
        adderNTimesToFile.addNTimesToFile(10);

        adderNTimesToFile.compressGzip();

        System.out.println("\n");
        System.out.println(serialized + adderNTimesToFile.sizeOfFile(FILE_PATH));
        System.out.println(compress + adderNTimesToFile.sizeOfFile(FILE_PATH_COMPRESS));
        System.out.println("\n");
        adderNTimesToFile.addNTimesToFile(10);
        System.out.println(serialized + adderNTimesToFile.sizeOfFile(FILE_PATH));
        System.out.println(compress + adderNTimesToFile.sizeOfFile(FILE_PATH_COMPRESS));
        System.out.println("\n");
        adderNTimesToFile.addNTimesToFile(10);
        System.out.println(serialized + adderNTimesToFile.sizeOfFile(FILE_PATH));
        System.out.println(compress + adderNTimesToFile.sizeOfFile(FILE_PATH_COMPRESS));

        adderNTimesToFile.clearFile(FILE_PATH);
        adderNTimesToFile.clearFile(FILE_PATH_COMPRESS);
    }

}
