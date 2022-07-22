package com.epam.radziievskyi.filereader.chainofrespon.filters;

import com.epam.radziievskyi.filereader.chainofrespon.chain.Filter;
import com.epam.radziievskyi.filereader.chainofrespon.util.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class FindByDateFilterAdderProductToListUtil{

    @Mock
    Filter filterNext;
    @InjectMocks
    FindByDateFilter findByDateFilter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldFindFilesBetweenTwoDatesWhenCallsOverrideMethodCheck() {

        //given
        findByDateFilter = Mockito.spy(new FindByDateFilter(filterNext));
        String firstDate = "30.05.2022";
        String secondDate = "31.05.2022";
        Scanner firstDateScan = new Scanner(firstDate);
        Scanner secondDateScan = new Scanner(secondDate);
        findByDateFilter.setFirstDate(Validator.validDateInput(firstDateScan));
        findByDateFilter.setSecondDate(Validator.validDateInput(secondDateScan));

        //when
        findByDateFilter.check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/another/iam.png"))
        ;
        findByDateFilter.check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/another/iam.png"));

        when(findByDateFilter.check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/another/iam.png"))
        ).thenReturn(true);
        when(findByDateFilter.check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/another/iam.png"))
        ).thenReturn(true);

        //then
        assertTrue(findByDateFilter.check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/another/iam.png"))
        );
        assertTrue(findByDateFilter.check(
                new File("/Users/pro/Desktop/pre_prod_java_winter_2022/src/main/resources/filesTask5/another/iam.png"))
        );
    }

}