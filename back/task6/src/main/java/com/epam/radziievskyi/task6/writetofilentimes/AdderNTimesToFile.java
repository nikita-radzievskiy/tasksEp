package com.epam.radziievskyi.task6.writetofilentimes;

import com.epam.radziievskyi.task6.container.ProductContainer;
import com.epam.radziievskyi.task6.serializer.Serializer;
import com.epam.radziievskyi.task6.serializer.impl.SerializerImpl;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.zip.GZIPOutputStream;

public class AdderNTimesToFile {

    private static final Logger LOGGER = Logger.getLogger(AdderNTimesToFile.class);

    private static final String FILE_PATH = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/serialization/serialized.GZip";
    private static final String compressGzip = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/serialization/compress.GZip";


    private final SerializerImpl serializerImpl = new SerializerImpl();
    private final ProductContainer productContainer = new ProductContainer();

    public void addNTimesToFile(int n) {
        for (int i = 0; i < n; i++) {
            serializerImpl.serialize(Collections.singletonList(productContainer.listWitProducts()));
            LOGGER.debug("Serialized" + i + " time");
        }
    }

    public void clearFile(String filePath) {
        serializerImpl.clearFile(filePath);
    }

    public long sizeOfFile(String filePath) {

        long size = 0;
        Path path = Paths.get(filePath);

        try {
            size = Files.size(path);
        } catch (IOException ioException) {
            System.out.println("File not found");
            LOGGER.error("File not found");
        }
        LOGGER.debug("Size of file is " + size);
        return size;
    }

    public void compressGzip() {


        byte[] buffer = new byte[1024];

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(compressGzip);
            GZIPOutputStream gzipOuputStream = new GZIPOutputStream(fileOutputStream);
            FileInputStream fileInput = new FileInputStream(FILE_PATH);

            int bytes_read;
            while ((bytes_read = fileInput.read(buffer)) > 0) {
                gzipOuputStream.write(buffer, 0, bytes_read);
            }
            fileInput.close();

            gzipOuputStream.finish();
            gzipOuputStream.close();

            System.out.println("The file was compressed successfully!");
        } catch (IOException ioException) {
            LOGGER.error("Error while compressing file");
            System.out.println("Error while compressing file");

        }
    }

}
