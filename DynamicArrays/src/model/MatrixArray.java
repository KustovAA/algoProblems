package model;

public class MatrixArray<T> implements IArray<T> {

    private int size;
    private int vector;
    private IArray<IArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector)
            array.add(new VectorArray<T>(vector));
        array.get(size / vector).add(item);
        size ++;
    }

    @Override
    public void add(T item, int index) {
        if (size == array.size() * vector)
            array.add(new VectorArray<T>(vector));
        int arrIndex = index / vector;
        array.get(arrIndex).add(item, index % vector);
        size++;
        while (arrIndex < array.size() - 1) {
            T removed = array.get(arrIndex).remove(vector);
            arrIndex++;
            array.get(arrIndex).add(removed, 0);
        }
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }

    @Override
    public T remove(int index) {
        int arrIndex = index / vector;
        T removed = array.get(arrIndex).remove(index % vector);
        while (arrIndex < array.size() - 1) {
            if (array.get(arrIndex + 1).size() > 0) {
                array.get(arrIndex).add(array.get(arrIndex + 1).remove(0));
            }
            arrIndex++;
        }
        size--;

        return removed;
    }
}
