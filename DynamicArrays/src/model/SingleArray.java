package model;

import java.util.Arrays;

public class SingleArray<T> implements IArray<T> {

    private T[] array;

    public SingleArray () {
        array = (T[]) new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize(true);
        array[size() - 1] = item;
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
        resize(false);

        return removed;
    }

    @Override
    public void add(T item, int index) {
        resize(true);
        T[] copyPart = Arrays.copyOfRange(array, index, size() - 1);
        System.arraycopy(
            copyPart,
            0,
            array,
            index + 1,
            copyPart.length
        );
        array[index] = item;
    }

    private void resize(boolean up) {
        int newSize = size() + (up ? 1 : -1);
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, Math.min(size(), newSize));
        array = (T[]) newArray;
    }
}
