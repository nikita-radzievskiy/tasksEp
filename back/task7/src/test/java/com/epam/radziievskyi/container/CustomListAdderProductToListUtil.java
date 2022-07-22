package com.epam.radziievskyi.container;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class CustomListAdderProductToListUtil{
    private CustomList list;

    @Before
    public void setUp() {
        list = new CustomList();
    }

    @Test
    public void testMethodRetainAll() {
        //given
        CustomList<Vehicle> list = new CustomList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "Germany", "BMW Motors", "I3", 4, 4, 2021, 160, 650, 80000, "900W");

        //when
        list.add(tesla);
        list.add(bmw);
        list.retainAll(list);

        //then
        assertEquals(2, list.size());
    }

    @Test
    public void checkNextElementInIteratorIfHasNextReturnTrue() {

        //given
        CustomList<Vehicle> list = new CustomList<Vehicle>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");


        //when
        list.add(tesla);
        Iterator<Vehicle> it = list.iterator();

        //then
        assertTrue(it.hasNext());
    }

    @Test
    public void shouldSwapToNextElementInIteratorWhenCalledMethodNextInIterator() {
        // given
        list = new CustomList<Vehicle>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "Germany", "BMW Motors", "I3", 4, 4, 2021, 160, 650, 80000, "900W");

        // when
        list.add(tesla);
        list.add(bmw);
        list.iterator().hasNext();

        //then
        @SuppressWarnings("unchecked")
        Vehicle next = (Vehicle) list.iterator().next();
        assertEquals(tesla, next);
    }


    @Test
    public void shouldAddElementToListByObjectWhenCalledAddWithObject() {
        //given
        CustomList<Vehicle> list = new CustomList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(tesla);

        //then
        assertEquals(1, list.size());

    }

    @Test
    public void shouldRemoveElementFromListByObjectWhenCalledRemoveMethod() {
        //given
        CustomList<Vehicle> list = new CustomList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(tesla);
        list.remove(0);

        //then
        assertEquals(0, list.size());

    }

    @Test
    public void shouldGetElementFromListByIndexWhenCalledMethodGet() {

        //given
        CustomList<Vehicle> list = new CustomList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(tesla);
        list.get(0);

        //then
        assertEquals(tesla, tesla);
    }

    @Test
    public void shouldAddElementToListByIndexWhenCalledAddWithIndex() {
        //given
        CustomList<Vehicle> list = new CustomList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        //when
        list.add(0, tesla);
        //then
        assertEquals(1, list.size());

    }

    @Test
    public void shouldRemoveElementFromListByIndexWhenCalledRemoveMethod() {
        //given
        CustomList<Vehicle> list = new CustomList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        //when
        list.add(tesla);
        list.remove(tesla);
        //then
        assertEquals(0, list.size());
    }

}