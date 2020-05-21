package model;

import java.util.Arrays;

public class FactorArray<T> implements IArray<T> {

    private T[] array;
    private final int factor;
    private int size;

    public FactorArray(int factor, int initLength) {
        this.factor = factor;
        array = (T[]) new Object[initLength];
        size = 0;
    }

    public FactorArray() {
        this(50, 10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            resize();
        array[size] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {
        if (size() == array.length)
            resize();

        T[] copyPart = Arrays.copyOfRange(array, index, size());
        System.arraycopy(
            copyPart,
            0,
            array,
            index + 1,
            copyPart.length
        );
        array[index] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T remove(int index) {
        T removed = get(index);
        T[] copyPart = Arrays.copyOfRange(array, index + 1, size() - 1);
        System.arraycopy(
            copyPart,
            0,
            array,
            index,
            copyPart.length - 1
        );
        size--;

        return removed;
    }

    private void resize() {
        Object[] newArray = new Object[array.length + array.length * factor / 100];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = (T[]) newArray;
    }
}
