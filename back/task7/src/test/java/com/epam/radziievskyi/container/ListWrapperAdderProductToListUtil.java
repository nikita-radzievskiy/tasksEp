package com.epam.radziievskyi.container;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)

public class ListWrapperAdderProductToListUtil{

    @Test
    public void checkNextElementInIteratorIfHasNextReturnTrue() {
        //given
        ListWrapper<Integer> list = new ListWrapper<>(Arrays.asList(1, 2, 3));

        //when
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();

        //then
        assertTrue(iterator.hasNext());
    }

    @Test
    public void shouldSwapToNextElementInIteratorWhenCalledMethodNextInIterator() {
        //given
        ListWrapper<Integer> list = new ListWrapper<>(new ArrayList<>());

        //when
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();

        //then
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(3, iterator.next().intValue());
    }

    @Test
    public void shouldAddElementToListByObjectWhenCalledAddWithObject() {
        //given
        ListWrapper<Integer> list = new ListWrapper<>(new ArrayList<>());

        //when
        list.add(1);
        list.add(2);
        list.add(3);

        //then
        assertEquals(3, list.size());
    }

    @Test
    public void shouldRemoveElementFromListByObjectWhenCalledRemoveMethod() {
        //given
        ListWrapper<Integer> listWrapper = new ListWrapper<>(new ArrayList<>());

        //when

        listWrapper.add(1);
        listWrapper.add(2);
        listWrapper.add(3);

        listWrapper.remove(4);


        //then
        assertEquals(2, listWrapper.size());
    }

    @Test
    public void shouldGetElementFromListByIndexWhenCalledMethodGet() {
        //given
        ListWrapper<Integer> list = new ListWrapper<>(new ArrayList<>());

        //when
        list.add(1);
        list.add(2);
        list.add(3);

        //then
        assertEquals(2, list.get(1).intValue());
    }

    @Test
    public void shouldAddElementToListByIndexWhenCalledAddWithIndex() {
        //given
        ListWrapper<Integer> list = new ListWrapper<>(new ArrayList<>());

        //when
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 5);

        //then
        assertEquals(4, list.size());
    }

    @Test
    public void shouldRemoveElementFromListByIndexWhenCalledRemoveMethod() {
        //given
        List<Integer> list = new ListWrapper<>(new ArrayList<>());

        //when
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(4);

        //then
        assertEquals(2, list.size());
    }

    @Test
    public void testAddMethodeInUnmodifiableList() {
        //given
        ListWrapper<Integer> list = new ListWrapper<>(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);
        //when
        list.add(4);
        //then
        assertEquals(4, list.size());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testMethodRemoveAllInUnmodifiableList() {
        //given
        List<Integer> list = new ListWrapper<>(Arrays.asList(1, 2, 3));
        list.add(1);
        list.add(2);
        list.add(3);
        //when
        list.removeAll(list);
    }

    @Test
    public void testMethodRetainAllInUnmodifiableList() {
        //given
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ListWrapper<>(Arrays.asList(1, 2));
        list.add(1);
        list.add(2);
        list.add(3);

        //when
        list2.retainAll(list);
        list.retainAll(list2);
        //then
        assertEquals(2, list2.size());
    }

    @Test
    public void testMethodContainsAllInModList() {
        //given
        ListWrapper<Integer> list = new ListWrapper<>(new ArrayList<>());
        ListWrapper<Integer> list2 = new ListWrapper<>(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        //when
        boolean contains = list.containsAll(list2);
        //then
        assertTrue(contains);
    }

    @Test
    public void testMethodClearInUnModList() {
        //given
        ListWrapper<Integer> list = new ListWrapper<>(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);
        //when
        list.clear();
        //then
        assertEquals(0, list.size());
    }

    @Test
    public void testMethodAddAllInUnmodList() {
        //given
        ListWrapper<Integer> list = new ListWrapper<>(new ArrayList<>());
        ListWrapper<Integer> list2 = new ListWrapper<>(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        //when
        list.addAll(list2);
        //then
        assertEquals(6, list.size());
    }
}