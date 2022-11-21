package me.zeroest.datastructure.list.array;

import me.zeroest.datastructure.list.MyList;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private Object[] items;
    private int numberOfItems;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.items = new Object[DEFAULT_CAPACITY];
        numberOfItems = 0;
    }

    public MyArrayList(int capacity) {
        this.items = new Object[capacity];
        numberOfItems = 0;
    }

    @Override
    public void add(int idx, T data) {
        validateIllegalIdx(idx);
        if (numberOfItems >= items.length) {
            rearrangeCapacity();
        }

        // shift right
        for (int i = numberOfItems-1 ; i >= idx ; i--) {
            items[i+1] = items[i];
        }
        // insert data
        items[idx] = data;
        numberOfItems++;
    }

    @Override
    public void append(T data) {
        if (numberOfItems >= items.length) {
            rearrangeCapacity();
        }

        items[numberOfItems++] = data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int idx) {
        validateIllegalIdx(idx);
        if (isEmpty()) {
            return null;
        }

        Object removedItem = items[idx];

        // shift left
        for (int i = idx; i <= numberOfItems-1 ;  i++) {
            if (i == numberOfItems - 1) {
                items[i] = null;
            } else {
                items[i] = items[i+1];
                items[i+1] = null;
            }
        }
        numberOfItems--;

        return (T) removedItem;
    }

    @Override
    public boolean remove(T data) {
        int idx = indexOf(data);
        if (idx == -1) {
            return false;
        }

        remove(idx);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int idx) {
        validateIllegalIdx(idx);

        return (T) items[idx];
    }

    @Override
    public void set(int idx, T data) {
        validateIllegalIdx(idx);

        items[idx] = data;
    }

    @Override
    public int indexOf(Object data) {
        int idx = 0;
        while (idx < numberOfItems && !items[idx].equals(data)) {
            idx++;
        }
        if (idx == numberOfItems) {
            idx = -1;
        }
        return idx;
    }

    @Override
    public int size() {
        return numberOfItems;
    }

    @Override
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    @Override
    public void clear() {
        this.items = new Object[items.length];
        this.numberOfItems = 0;
    }

    private void rearrangeCapacity() {
        Object[] rearrangeItems = new Object[this.items.length + DEFAULT_CAPACITY];
        System.arraycopy(this.items, 0, rearrangeItems, 0, this.items.length);
        this.items = rearrangeItems;
    }

    private void validateIllegalIdx(int idx) {
        int maxIdx = numberOfItems - 1;
        if (numberOfItems == 0) {
            maxIdx = 0;
        }

        if (idx < 0 || idx > maxIdx) {
            throw new IllegalArgumentException("Illegal index");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
