package com.epam.radziievskyi.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListWrapper <T> implements List<T> {
    private final List<T> modList;
    private final List<T> unModList;

    public ListWrapper (List<T> unModList) {
        modList = new ArrayList<>();
        this.unModList = unModList;
    }

    @Override

    public int size () {
        return unModList.size() + modList.size();
    }

    @Override
    public boolean isEmpty () {
        return unModList.isEmpty() && modList.isEmpty();
    }

    @Override
    public boolean contains (Object object) {
        boolean contains = modList.contains(object) && unModList.contains(object);
        return contains;
    }

    @Override
    public Iterator<T> iterator () {
        return new ListWrapperIterator();
    }

    @Override
    public Object[] toArray () {
        Object[] array = new Object[modList.size() + unModList.size()];
        for (int i = 0; i < modList.size(); i++) {
            array[i] = modList.get(i);
        }
        for (int i = 0; i < unModList.size(); i++) {
            array[i + modList.size()] = unModList.get(i);
        }
        return array;
    }

    @Override
    public boolean add (T element) {
        return modList.add(element);
    }

    @Override
    public boolean remove (Object object) {
        return modList.remove(object);
    }

    @Override
    public boolean containsAll (Collection<?> collection) {
        boolean contains = false;
        for (Object object : collection) {
            contains = contains || modList.contains(object) || unModList.contains(object);
        }
        return contains;
    }

    @Override
    public boolean addAll (Collection<? extends T> collection) {
        modList.addAll(collection);
        return true;
    }

    @Override
    public boolean removeAll (Collection<?> collection) {
        for (Object object : collection) {
            for (T unModEl : unModList) {
                if (unModEl.equals(object)) {
                    throw new UnsupportedOperationException();
                }
            }
        }

        return modList.removeAll(collection);
    }

    @Override
    public boolean retainAll (Collection<?> collection) {
        for (Object object : collection) {
            for (T unModEl : unModList) {
                if (!collection.contains(unModEl)) {
                    throw new UnsupportedOperationException();
                }
            }
        }

        return modList.retainAll(collection);
    }


    @Override
    public <T1> T1[] toArray (T1[] elements) {
        Object[] array = new Object[modList.size() + unModList.size()];
        for (int i = 0; i < modList.size(); i++) {
            array[i] = modList.get(i);
        }
        for (int i = 0; i < unModList.size(); i++) {
            array[i + modList.size()] = unModList.get(i);
        }
        return (T1[]) array;
    }


    @Override
    public void clear () {
        modList.clear();
    }


    @Override
    public T get (int index) {
        if (index < modList.size()) {
            return modList.get(index);
        } else {
            return unModList.get(index - modList.size());
        }
    }

    @Override
    public T set (int index, T element) {
        if (index < modList.size()) {
            return modList.set(index, element);
        } else {
            return unModList.set(index - modList.size(), element);
        }
    }

    @Override
    public void add (int index, T element) {
        if (index < modList.size()) {
            modList.add(index, element);
        } else {
            unModList.add(index - modList.size(), element);
        }
    }

    @Override
    public T remove (int index) {
        if (index < unModList.size()) {
            throw new UnsupportedOperationException();
        }
        return modList.remove(index - modList.size() - 1);
    }

    @Override
    public int indexOf (Object object) {

        if (modList.contains(object)) {
            return modList.indexOf(object);
        } else if (unModList.contains(object)) {
            return modList.size() + unModList.indexOf(object);
        } else {
            return -1;
        }
    }

    @Override
    public int lastIndexOf (Object object) {
        if (modList.contains(object)) {
            return modList.lastIndexOf(object);
        } else if (unModList.contains(object)) {
            return modList.size() + unModList.lastIndexOf(object);
        } else {
            return -1;
        }
    }


    @Override
    public boolean addAll (int index, Collection<? extends T> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        final int size = collection.size();
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        for (T t : collection) {
            if (i == index) {
                add(t);
            }
            i++;
        }
        return true;
    }


    @Override
    public ListIterator<T> listIterator () {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator (int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList (int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString () {
        return unModList + " " + modList;
    }

    private class ListWrapperIterator implements Iterator<T> {
        private int index = 0;
        private Iterator<T> iterator;

        public ListWrapperIterator () {
            iterator = modList.iterator();
        }

        @Override
        public boolean hasNext () {
            if (index < modList.size()) {
                return true;
            } else if (index == modList.size()) {
                iterator = unModList.iterator();
                return iterator.hasNext();
            } else {
                return false;
            }
        }

        @Override
        public T next () {
            if (index < modList.size()) {
                return modList.get(index++);
            } else {
                return iterator.next();
            }
        }
    }
}
