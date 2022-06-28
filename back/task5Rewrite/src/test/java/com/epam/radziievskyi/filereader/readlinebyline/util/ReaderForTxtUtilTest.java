package com.epam.radziievskyi.filereader.readlinebyline.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;

class ReaderForTxtUtilTest {

    @InjectMocks
    ReaderForTxtUtil readerForTxtUtil;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnTrueWhenCallsHasNextInIterator() {
        //given
        readerForTxtUtil = new ReaderForTxtUtil("src/main/resources/filesTask5/txt/", "text");
        //when
        Iterator<String> iterator = readerForTxtUtil.iterator();
        //then
        Assertions.assertTrue(iterator.hasNext());
    }

    @Test
    void shouldPrintLineFromFileWhenCallsConstructorWithFilePathAndFileName() {
        //given
        ReaderForTxtUtil readerForTxtUtil = new ReaderForTxtUtil("src/main/resources/filesTask5/txt/", "text");
        //when
        String iterator = readerForTxtUtil.iterator().next();
        //then
        Assertions.assertEquals("[Текст песни «Знаешь, Таня»]", iterator);
    }

}
