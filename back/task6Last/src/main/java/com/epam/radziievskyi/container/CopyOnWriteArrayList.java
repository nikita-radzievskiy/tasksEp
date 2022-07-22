package com.epam.radziievskyi.container;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CopyOnWriteArrayList <E> implements List<E> {

    private static final int CAPACITY = 50;
    private Object[] items = new Object[CAPACITY];
    private int size = 0;


    @Override
    public int size () {
        return size;
    }

    @Override
    public boolean isEmpty () {
        return size == 0;
    }

    @Override
    public boolean contains (Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Iterator<E> iterator () {
        return new Iter();
    }

    @Override
    public Object[] toArray () {
        return Arrays.copyOf(items, size);
    }

    @Override
    public boolean add (Object object) {
        items = Arrays.copyOf(items, size + 1);
        items[size] = object;
        size++;
        return true;
    }

    @Override
    public boolean remove (Object object) {
        Object[] copy = Arrays.copyOf(items, size);
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(object)) {
                size--;
                result = true;
                break;
            }
        }
        items = copy;
        return result;
    }

    @Override
    public boolean addAll (Collection<? extends E> collection) {
        for (E colEl : collection) {
            add(colEl);
        }
        return true;
    }

    @Override
    public boolean addAll (int index, Collection<? extends E> collection) {
        for (E colEl : collection) {
            if (index == size) {
                add(colEl);
            } else {
                add(index, colEl);
            }
        }
        return true;
    }

    @Override
    public void clear () {
        Object[] copy = new Object[CAPACITY];
        items = copy;
        size = 0;
    }

    @Override
    public E get (int index) {
        checkIndexBound(index);
        return (E) items[index];
    }

    @Override
    public Object set (int index, Object element) {
        checkIndexBound(index);
        Object result = items[index];
        items[index] = element;
        return result;
    }

    @Override
    public void add (int index, Object element) {
        checkIndexBound(index);
        Object[] copy = Arrays.copyOf(items, size + 1);
        for (int i = size; i > index; i--) {
            copy[i] = items[i - 1];
        }
        copy[index] = element;
        items = copy;
        size++;
    }

    @Override
    public E remove (int index) {
        checkIndexBound(index);
        Object[] copy = Arrays.copyOf(items, size);
        Object result = copy[index];
        for (int i = index; i < size; i++) {
            copy[i] = items[i + 1];
        }
        items = copy;
        size--;
        return (E) result;
    }

    @Override
    public int indexOf (Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf (Object object) {
        int index = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(object)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public ListIterator listIterator () {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator (int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList (int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll (Collection collection) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (collection.contains(items[i])) {
                result = true;
            } else {
                remove(i);

            }
        }
        return result;
    }

    @Override
    public boolean removeAll (Collection collection) {
        boolean flag = false;
        for (Object object : collection) {
            if (remove(object)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean containsAll (Collection collection) {
        for (Object obj : collection)
            if (!contains(obj)) {
                return false;
            }
        return true;
    }

    @Override
    public Object[] toArray (Object[] object) {
        if (object.length < size) {
            return Arrays.copyOf(items, size, Object[].class);
        }
        System.arraycopy(items, 0, object, 0, size);
        if (object.length > size) {
            object[size] = null;
        }
        return object;
    }

    @Override
    public String toString () {
        return Arrays.toString(items);
    }

    public void checkIndexBound (int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public class Iter implements Iterator {
        private int index = 0;
        private final boolean nextObjectSet = false;
        private int currentIndex;
        private boolean hasNextElement;
        private boolean canDeleteElement;

        @Override
        public boolean hasNext () {
            return hasNextElement;
        }

        @Override
        public Object next () {
            if (hasNextElement) {
                canDeleteElement = true;
                currentIndex = index;
                index++;
                if (index == size) {
                    hasNextElement = false;
                }
                return items[currentIndex];
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override
        public void remove () {
            Object[] newItems = new Object[items.length];
            if (canDeleteElement) {
                for (int i = 0; i < items.length; i++) {
                    if (i != currentIndex) {
                        newItems[i] = items[i];

                    }
                }
            }
        }
    }
}


