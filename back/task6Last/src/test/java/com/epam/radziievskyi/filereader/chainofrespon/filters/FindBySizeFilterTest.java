package com.epam.radziievskyi.filereader.chainofrespon.filters;

import com.epam.radziievskyi.filereader.chainofrespon.chain.Filter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class FindBySizeFilterTest {

    @Mock
    Filter filterNext;
    @InjectMocks
    FindBySizeFilter findBySizeFilter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldFindFileBySizeWhenCallsOverrideMethodCheck() {

        //given
        findBySizeFilter = Mockito.spy(new FindBySizeFilter(filterNext));
        long sizeMin = 0;
        long sizeMax = 1500;

        //when
        findBySizeFilter.setSizeMin(sizeMin);
        findBySizeFilter.setSizeMax(sizeMax);
        findBySizeFilter.check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/txt/text"));

        //then
        verify(findBySizeFilter, times(1)).check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/txt/text"));
    }

}