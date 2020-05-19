package model;

import java.util.Arrays;

public class VectorArray<T> implements IArray<T> {

    private T[] array;
    private int vector;
    private int size;

    public VectorArray(int vector) {
        this.vector = vector;
        array = (T[]) new Object[0];
        size = 0;
    }

    public VectorArray() {
        this(10);
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
        T[] copyPart = Arrays.copyOfRange(array, Math.min(index + 1, size() - 1), size());
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
        Object[] newArray = new Object[array.length + vector];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = (T[]) newArray;
    }
}
