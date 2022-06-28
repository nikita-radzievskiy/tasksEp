package com.epam.radziievskyi.container;

import java.util.ArrayList;
import java.util.Collection;

public class ListWithUniqElements<E> extends ArrayList<E> {

    public ListWithUniqElements() {
    }

    public ListWithUniqElements(ArrayList<E> list) {
        super(list);
    }

    @Override
    public boolean add(E object) {
        if (this.contains(object)) {
            System.out.println("Element already exists " + object);
            return false;
        } else {
            super.add(object);
        }
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (isExistElement(element)) {
            System.out.println("Element already exists " + element);
        } else {
            super.add(index, element);
        }
    }


    @Override
    public E set(int index, E element) {
        checkByNull(index, element);
        return super.set(index, element);
    }


    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E element : collection) {
            if (isExistElement(element)) {
                System.out.println("Element already exists " + element);
            } else {
                this.add(element);
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        for (E element : collection) {
            if (isExistElement(element)) {
                System.out.println("Element already exists " + element);
            } else {
                this.add(index, element);
            }
        }
        return true;
    }

    private boolean isExistElement(Object element) {
        return this.contains(element) || element == null;
    }

    public void checkByNull(int index, E element) {
        if (this.contains(element) || element == null || index < 0 || index > this.size()) {
            throw new UnsupportedOperationException("Element " + element + " already exists ");
        }
    }
}

