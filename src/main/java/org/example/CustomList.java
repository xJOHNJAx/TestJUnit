package org.example;

public class CustomList<E> {
    private Object[] data;
    private int size;

    public CustomList() {
        data = new Object[10];
        size = 0;
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        data[size++] = element;
    }

    public void addAll(E[] elementsArray) {
        for (E element : elementsArray) {
            add(element);
        }
    }

    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E) data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return oldValue;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - data.length > 0) {
            int newSize = Math.max(data.length * 2, minCapacity);
            Object[] newData = new Object[newSize];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) data[index];
    }

    public int size() {
        return size;
    }


}
