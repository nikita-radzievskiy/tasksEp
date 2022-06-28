package com.epam.radziievskyi.container;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import com.epam.radziievskyi.utils.FilterUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CustomListTest {
    private CustomList list;

    @Before
    public void setUp() {
        list = new CustomList();
    }

    @Test
    void checkNextElementInIteratorIfHasNextReturnTrue() {

        //given
        CustomList<Vehicle> list = new CustomList<Vehicle>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");


        //when
        list.add(tesla);
        Iterator<Vehicle> it = list.iterator();

        //then
        Assertions.assertTrue(it.hasNext());
    }

    @Test
    void shouldSwapToNextElementInIteratorWhenCalledMethodNextInIterator() {
        // given
        Predicate<Vehicle> predicate = new Predicate<Vehicle>() {
            @Override
            public boolean test(Vehicle vehicle) {
                return vehicle.getManufacturerCountry().equals("USA");
            }
        };
        list = new CustomList<Vehicle>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "Germany", "BMW Motors", "I3", 4, 4, 2021, 160, 650, 80000, "900W");

        // when
        list.add(tesla);
        list.add(bmw);
        Iterator itr = list.iterator(predicate);

        //then
        while (itr.hasNext()) {
            Vehicle element = (Vehicle) itr.next();
            Assert.assertEquals(tesla, element);
        }
    }


    @Test
    void shouldAddElementToListByObjectWhenCalledAddWithObject() {
        //given
        CustomList<Vehicle> list = new CustomList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(tesla);

        //then
        assertEquals(1, list.size());

    }

    @Test
    void shouldRemoveElementFromListByObjectWhenCalledRemoveMethod() {
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
    void shouldGetElementFromListByIndexWhenCalledmethodGet() {

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
    void shouldAddElementToListByIndexWhenCalledAddWithIndex() {
        //given
        CustomList<Vehicle> list = new CustomList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        //when
        list.add(0, tesla);
        //then
        assertEquals(1, list.size());

    }

    @Test
    void shouldRemoveElementFromListByIndexWhenCalledRemoveMethod() {
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