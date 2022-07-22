package com.epam.radziievskyi.task6.writetofilentimes;

import com.epam.radziievskyi.shop.dao.impl.ProductDAOImpl;
import com.epam.radziievskyi.task6.serializer.impl.SerializerImpl;
import com.epam.radziievskyi.task6.strategy.InputStrategy;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;

public class AdderNTimesToFile {

    private static final Logger LOGGER = Logger.getLogger(AdderNTimesToFile.class);

    private static final String FILE_PATH = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/serialization/serialized.GZip";
    private static final String COMPRESS_GZIP = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/serialization/compress.GZip";
    private final SerializerImpl serializerImpl = new SerializerImpl();
    private InputStrategy inputStrategy;
    private final ProductDAOImpl productContainer = new ProductDAOImpl();

    public static void main (String[] args) {
        AdderNTimesToFile adderNTimesToFile = new AdderNTimesToFile();
        adderNTimesToFile.addNTimesToFile(10);

        adderNTimesToFile.compressGzip();
        System.out.println("file " + adderNTimesToFile.sizeOfFile(FILE_PATH));
        System.out.println("compress " + adderNTimesToFile.sizeOfFile(COMPRESS_GZIP));
        System.out.println("\n");
        adderNTimesToFile.addNTimesToFile(20);
        System.out.println("file " + adderNTimesToFile.sizeOfFile(FILE_PATH));
        System.out.println("compress " + adderNTimesToFile.sizeOfFile(COMPRESS_GZIP));
        System.out.println("\n");

        adderNTimesToFile.addNTimesToFile(30);
        System.out.println("file " + adderNTimesToFile.sizeOfFile(FILE_PATH));
        System.out.println("compress " + adderNTimesToFile.sizeOfFile(COMPRESS_GZIP));

        adderNTimesToFile.clearFile(FILE_PATH);
        adderNTimesToFile.clearFile(COMPRESS_GZIP);

    }

    public void clearFile (String filePath) {
        serializerImpl.clearFile(filePath);
    }

    public long sizeOfFile (String filePath) {

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

    public void addNTimesToFile (int n) {
        for (int i = 0; i < n; i++) {
            serializerImpl.serialize(productContainer.listWitProductsForSerializeTest());
        }
    }

    public void compressGzip () {
        byte[] buffer = new byte[1024];

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(COMPRESS_GZIP);
            GZIPOutputStream gzipOuputStream = new GZIPOutputStream(fileOutputStream);
            FileInputStream fileInput = new FileInputStream(FILE_PATH);

            int bytes_read;
            while ((bytes_read = fileInput.read(buffer)) > 0) {
                gzipOuputStream.write(buffer, 0, bytes_read);
            }
            fileInput.close();

            gzipOuputStream.finish();
            gzipOuputStream.close();

            System.out.println("The file was compressed successfully!\n");
        } catch (IOException ioException) {
            LOGGER.error("Error while compressing file");
            System.out.println("Error while compressing file");
        }
    }

}
