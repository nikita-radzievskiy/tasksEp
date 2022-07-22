package com.epam.radziievskyi.filereader.chainofrespon.filters;

import com.epam.radziievskyi.filereader.chainofrespon.chain.Filter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.util.Scanner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class FindByFormatFilterAdderProductToListUtil{

    @Mock
    Filter filterNext;
    @InjectMocks
    FindByFormatFilter findByFormatFilter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldFindFileByFormatWhenCallsOverrideMethodCheck() {
        //given
        findByFormatFilter = Mockito.spy(new FindByFormatFilter(filterNext));
        String extension = "txt";
        Scanner scanner = new Scanner(extension);

        //when
        findByFormatFilter.setExtension(extension);
        findByFormatFilter.check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/txt/text"));

        //then
        verify(findByFormatFilter, times(1)).check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/txt/text"));
    }

}