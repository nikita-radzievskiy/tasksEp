package com.epam.radziievskyi.container;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CustomList<T> implements List<T> {
    private static int CAPACITY = 50;
    private final Object[] items = new Object[CAPACITY];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    public void resize() {
        CAPACITY = CAPACITY + 50;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object object) {
        boolean flag = false;
        for (int i = 0; i < size(); i++) {
            if (object.equals(items[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public Iterator<T> iterator(Predicate predicate) {
        return new Iter(predicate);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] arr) {
        if (arr.length < size)
            return (T1[]) Arrays.copyOf(items, size, arr.getClass());
        System.arraycopy(items, 0, arr, 0, size);
        if (arr.length > size)
            arr[size] = null;
        return arr;
    }

    @Override
    public boolean add(T add) {
        if (size() < CAPACITY) {
            items[size] = add;
            size++;
        } else {
            resize();
            items[size] = add;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object object) {
        boolean flag = false;
        for (int i = 0; i < size(); i++) {
            if (object.equals(items[i])) {
                items[i] = null;
                size--;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection)
            if (!contains(obj)) {
                return false;
            }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean modified = false;
        Iterator<? extends T> iter = collection.iterator();
        while (iter.hasNext()) {
            if (add(iter.next()))
                modified = true;
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        final int size = collection.size();
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(
                    "An out of bounds index specified: " + index);
        }
        int i = 0;
        boolean collectionChanged = false;
        for (Iterator<? extends T> iter = collection.iterator(); iter.hasNext(); ++i) {
            T elem = iter.next();
            if (i >= index) {
                collectionChanged = true;
                add(elem);
            }
        }
        return collectionChanged;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = false;
        for (Object obj : collection) {
            if (remove(obj)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean flag = false;
        for (int i = 0; i < size(); i++) {
            if (!collection.contains(items[i])) {
                items[i] = null;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        for (int i = 0; i < size; i++) {
            items[i] = operator.apply((T) items[i]);
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) comparator);
        ListIterator<T> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((T) e);
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        return (T) items[index];
    }

    @Override
    public T set(int index, T element) {
        items[index] = element;
        return (T) items[index];
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= size) {
            System.arraycopy(items, index, items, index + 1, size - index);
            items[index] = element;
            size++;
        }
    }

    @Override
    public T remove(int index) {
        if (items[index] != null) {
            items[index] = null;
            System.out.println("Item with index: " + index + " removed");
            size--;
        }
        return (T) items[index];
    }

    @Override
    public int indexOf(Object object) {
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
    public int lastIndexOf(Object object) {
        int index = 0;
        for (int i = items.length - 1; i >= 0; i--) {
            if (object.equals(items[i])) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }

    public class Iter implements Iterator<T> {
        private final boolean nextObjectSet = false;
        private final Predicate<? super T> predicate;
        private int currentIndex;
        private boolean hasNextElement;
        private boolean canDeleteElement;


        public Iter() {
            super();
            predicate = x -> true;
        }

        public Iter(Predicate<T> predicate) {
            this.predicate = predicate;
        }

        @Override
        public boolean hasNext() {
            if (hasNextElement) {
                return true;
            }

            return setNextElement();
        }

        @Override
        public T next() {
            if (!hasNextElement && !setNextElement()) {
                throw new NoSuchElementException();
            }

            canDeleteElement = true;
            hasNextElement = false;
            return (T) items[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private boolean setNextElement() {
            while (currentIndex < size) {
                Object object = items[currentIndex];
                if (predicate.test((T) object)) {
                    hasNextElement = true;
                    return true;
                }
                currentIndex++;
            }
            return false;
        }
    }
}


