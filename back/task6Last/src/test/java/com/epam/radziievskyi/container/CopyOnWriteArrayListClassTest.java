package com.epam.radziievskyi.container;

import com.epam.radziievskyi.entity.ElectroCar;
import com.epam.radziievskyi.entity.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)


public class CopyOnWriteArrayListClassTest {

    @Test
    public void shouldAddItemToCopyOnWriteArrayListByIndex() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "USA", "BMW", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle audi = new ElectroCar("ElectroCar", "USA", "Audi", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle mercedes = new ElectroCar("ElectroCar", "USA", "Mercedes", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle volvo = new ElectroCar("ElectroCar", "USA", "Volvo", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle honda = new ElectroCar("ElectroCar", "USA", "Honda", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle ford = new ElectroCar("ElectroCar", "USA", "Ford", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle chevrolet = new ElectroCar("ElectroCar", "USA", "Chevrolet", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");


        //when
        list.add(0, tesla);
        list.add(1, bmw);
        list.add(2, audi);
        list.add(3, mercedes);
        list.add(4, volvo);
        list.add(5, honda);
        list.add(6, ford);
        list.add(7, chevrolet);

        Iterator<Vehicle> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            list.add(1, tesla);
            iterator1.next();
        }

        //then
        assertEquals(8, list.size());

    }

    @Test
    public void shouldRemoveItemFromCopyOnWriteArrayListByObject() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(0, tesla);
        Iterator<Vehicle> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            list.remove(tesla);
            iterator1.next();
        }

        //then
        assertEquals(1, list.size());
    }

    @Test
    public void shouldRemoveItemFromCopyOnWriteArrayListByIndex() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(0, tesla);
        Iterator<Vehicle> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            list.remove(0);
            iterator1.next();
        }

        //then
        assertEquals(1, list.size());
    }

    @Test
    public  void shouldReturnTrueIfListContainsItem() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "USA", "BMW", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(0, tesla);
        boolean result = list.contains(bmw);
        boolean result2 = list.contains(tesla);

        //then
        assertTrue(result2);
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseIfListDoesNotContainsItem() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "USA", "BMW", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(0, tesla);
        boolean result = list.contains(bmw);

        //then
        assertFalse(result);
    }

    @Test
    public void shouldAddElementToListAndCopyOnWriteArrayList() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "USA", "BMW", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(tesla);
        Iterator<Vehicle> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            list.add(bmw);
            iterator1.next();
        }

        //then
        assertEquals(1, list.size());
    }

    @Test
    public  void testMethodRetainAllInCopyOnWriteList() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        List<Vehicle> list2 = new CopyOnWriteArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "USA", "BMW", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle audi = new ElectroCar("ElectroCar", "USA", "Audi", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(tesla);
        list.add(bmw);
        list.add(audi);

        list2.add(bmw);
        list2.add(audi);

        list2.retainAll(list);

        //then
        assertEquals(2, list2.size());
    }

    @Test
    public void addAllTestCopyOnWriteClass() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        List<Vehicle> list2 = new ArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "USA", "BMW", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle audi = new ElectroCar("ElectroCar", "USA", "Audi", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(tesla);
        list.add(bmw);
        list.add(audi);

        list2.add(bmw);
        list2.add(audi);

        list.addAll(list2);
        list.size();
        list2.size();

        //then
        assertEquals(5, list.size());
    }

    @Test
    public void testMethodAddAllWithIndex() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        List<Vehicle> list2 = new ArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "USA", "BMW", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle audi = new ElectroCar("ElectroCar", "USA", "Audi", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(tesla);
        list.add(bmw);
        list.add(audi);

        list2.add(bmw);
        list2.add(audi);

        list.addAll(1, list2);

        //then
        assertEquals(5, list.size());
    }

    @Test
    public  void testMethodGetCopyOnWriteList() {
        // given
        List<Vehicle> list = new CopyOnWriteArrayList<>();
        Vehicle tesla = new ElectroCar("ElectroCar", "USA", "Tesla", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle bmw = new ElectroCar("ElectroCar", "USA", "BMW", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");
        Vehicle audi = new ElectroCar("ElectroCar", "USA", "Audi", "Model X", 4, 5, 2021, 260, 1050, 140000, "2000W");

        //when
        list.add(tesla);
        list.add(bmw);
        list.add(audi);

        //then
        assertEquals(tesla, list.get(0));
    }
}
