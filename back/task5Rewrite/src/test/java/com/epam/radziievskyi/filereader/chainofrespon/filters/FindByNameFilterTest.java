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

class FindByNameFilterTest {

    @Mock
    Filter filterNext;
    @InjectMocks
    FindByNameFilter findByNameFilter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldFindFileByNameWhenCallsOverrideMethodCheck() {
        //given
        findByNameFilter = Mockito.spy(new FindByNameFilter(filterNext));
        String fileName = "text";
        String filePath = "/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/txt/";

        //when
        findByNameFilter.setFileName(fileName);
        findByNameFilter.check(new File(filePath));

        //then
        verify(findByNameFilter, times(1)).check(new File(filePath));
    }

}
