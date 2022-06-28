package com.epam.radziievskyi.container;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class ListWithUniqElementsTest {

    @Test
    public void shouldAddAllElementsIfOneOfThemDoNotExistInListWithUniqElWhenAddAllMethodCalls() {
        // Given
        List<Integer> uniqElements = new ListWithUniqElements<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        // When
        uniqElements.addAll(list);

        // Then
        assert uniqElements.size() == 20;

        List<Integer> list2 = new ArrayList<>(Arrays.asList(20, 22, 23, 24, 25, 26, 27, 28, 29, 30));
        uniqElements.addAll(list2);

        // Then
        assert uniqElements.size() == 29;

    }

    @Test
    public void shouldAddAllElementsIfOneOfThemDoNotExistInListWithUniqElWhenAddAllByIndexMethodCalls() {
        // Given
        List<Integer> uniqElements = new ListWithUniqElements<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        // When
        uniqElements.addAll(0, list);

        // Then
        assert uniqElements.size() == 20;

        List<Integer> list2 = new ArrayList<>(Arrays.asList(20, 22, 23, 24, 25, 26, 27, 28, 29, 30));
        uniqElements.addAll(0,list2);

        // Then
        assert uniqElements.size() == 29;
    }

    @Test
    public void shouldGetAMessageElementExistWhenAddSameElementWhenAddMethodCalls() {
        // Given
        List<Integer> list = new ListWithUniqElements<>(new ArrayList<>(Arrays.asList(1)));

        // When
        list.add(1);

        // Then
        assert list.size() == 1;
    }

    @Test
    public void shouldGetAMessageElementExistWhenAddByIndexSameElementWhenAddByIndexMethodCalls() {
        // Given
        List<Integer> list = new ListWithUniqElements<>(new ArrayList<>(Arrays.asList(1)));

        // When
        list.add(1, 1);


        // Then
        assert list.size() == 1;
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldGetAMessageElementExistWhenSetByIndexSameElementWhenSetMethodCalls() {
        // Given
        List<Integer> list = new ListWithUniqElements<>(new ArrayList<>(Arrays.asList(1, 2, 3)));

        // When
        list.set(0, 1);

    }
}